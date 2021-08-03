public class User {
    
    private String name;
    
    public String changeName(String name, Consumer<User> f) {
        this.name = name;
        f.accept(this);
    }
}

public class UserService {

    private final UserMapper userMapper;

    public void changeName(String name) {
        new User().changeName(name, user -> userMapper.save());
    }
}