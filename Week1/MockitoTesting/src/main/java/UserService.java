public class UserService {

    private UserRepository userRepository;

    // Constructor Injection — DIP principle
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUser(int id) {
        return userRepository.findUserById(id);
    }

    public boolean createUser(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        return userRepository.saveUser(name);
    }
}