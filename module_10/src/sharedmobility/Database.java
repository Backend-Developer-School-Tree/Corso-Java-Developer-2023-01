package sharedmobility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Database instance = null;

    private Path usersCsv;
    private List<User> users;

    private Database(Path usersCsv) {
        this.usersCsv = usersCsv;
        this.users = new ArrayList<>();

        try {
            if (!Files.exists(usersCsv))
                Files.createFile(usersCsv);
        } catch (IOException e) { e.printStackTrace(); }

        try (BufferedReader br = Files.newBufferedReader(usersCsv)) {
            String line;
            while ((line = br.readLine()) != null) {
                // "1,Mario,Mario,1981-07-09"
                // "2,Luigi,Mario,1983-03-04"
                // "3,Francesco,Totti,1976-09-27"
                this.users.add(User.parseCsv(line));
            }
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public static Database getInstance() {
        if (instance != null)
            return instance;

        throw new DatabaseInstanceNotDefined();
        // throw new RuntimeException("Database instance does not exist");
    }

    public static Database getInstance(Path usersCsv) {
        if (instance != null && usersCsv.equals(instance.usersCsv))
            return instance;

        instance = new Database(usersCsv);
        return instance;
    }

    public boolean insertUser(User user) {
        int lastId = 0;

        if (users.size() > 0)
            lastId = users.get(users.size()-1).getId();

        user.setId(lastId+1);
        // insert user in this.users
        users.add(user);

        // insert user in csv
        return updateUsersCsv();
    }

    public void removeUser(int userId) {
        // remove user from this.users
        // remove user from csv
    }

    private boolean updateUsersCsv() {
        try (BufferedWriter bw = Files.newBufferedWriter(this.usersCsv)) {
            for (User user : users) {
                bw.write(user.getCsv());
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
        Database db = Database.getInstance(Paths.get("module_10", "src", "sharedmobility", "users.csv"));
        // Database db = new Database(Paths.get("module_10", "src", "sharedmobility", "users.csv"));
        Database db2 = Database.getInstance(Paths.get("module_10", "src", "sharedmobility", "users.csv"));
        // Database db2 = new Database(Paths.get("module_10", "src", "sharedmobility", "users.csv"));

        db.insertUser(new User(1,"Nuovo", "Utente", LocalDate.of(2023, 2, 28)));
        System.out.println(db.users);
        System.out.println(db2.users);
        db2.updateUsersCsv();
    }
}
