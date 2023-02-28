package esempi.dao;

import java.util.List;

// Questa classe idealmente implementerà le stesse funzionalità di UserDaoCsv ma tramite un database SQL vero e proprio
// semplificando la flessibilità di poter passare ad utilizzare il formato SQL piuttosto che l'attuale CSV
public class UserDaoSql implements UserDao {
    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
