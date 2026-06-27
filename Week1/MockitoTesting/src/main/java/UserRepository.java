public interface UserRepository {
    String findUserById(int id);
    boolean saveUser(String name);
}