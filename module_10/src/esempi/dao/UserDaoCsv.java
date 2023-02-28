package esempi.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class UserDaoCsv implements UserDao {

    private Path usersCsv;
    private TreeMap<Integer, User> idsToUsers;

    public UserDaoCsv(Path usersCsv) {
        this.usersCsv = usersCsv;
        this.idsToUsers = new TreeMap<>();

        try {
            if (!Files.exists(usersCsv))
                Files.createFile(usersCsv);
        } catch (IOException e) { e.printStackTrace(); }

        try (BufferedReader br = Files.newBufferedReader(usersCsv)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Integer id = Integer.parseInt(values[0]);
                this.idsToUsers.put(id, new User(id, values[1], values[2], LocalDate.parse(values[3])));
            }
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    public boolean insert(User user) {
        int lastId = 0;

        if (idsToUsers.size() > 0)
            lastId = idsToUsers.lastKey();

        user.setId(lastId + 1);
        this.idsToUsers.put(user.getId(), user);

        return save();
    }

    @Override
    public boolean update(User user) {
        this.idsToUsers.put(user.getId(), user);
        return save();
    }

    @Override
    public boolean delete(int id) {
        User removedUser = idsToUsers.remove(id);

        if (removedUser != null)
            return save();
        else
            return false;
    }

    @Override
    public User get(int id) {
        return idsToUsers.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(idsToUsers.values());
    }

    private boolean save() {
        try (BufferedWriter bw = Files.newBufferedWriter(this.usersCsv)) {
            for (User user : idsToUsers.values()) {
                List<String> values = Arrays.asList(
                        user.getId().toString(),
                        user.getName(),
                        user.getLastName(),
                        user.getBirthday().toString());

                bw.write(String.join(",", values));
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDaoCsv(Paths.get("module_10", "src", "esempi", "dao", "users.csv"));

        userDao.insert(new User(1,"Andrea", "Rossi", LocalDate.of(2023, 2, 28)));
        userDao.insert(new User(2,"Luca", "Verdi", LocalDate.of(2023, 2, 27)));

        System.out.println(userDao.getAll());

        System.out.println(userDao.get(1));
        userDao.update(new User(1,"Giovanni", "Rossi", LocalDate.of(2023, 2, 28)));
        System.out.println(userDao.get(1));

        System.out.println(userDao.get(1));
        userDao.delete(1);
        System.out.println(userDao.get(1));

        System.out.println(userDao.getAll());
    }
}
