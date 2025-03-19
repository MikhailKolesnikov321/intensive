package dunice.net.task1;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserDTO getUserDtoById(Long id) {
    Optional<User> userOptional = userRepository.findById(id);
    User user = userOptional.orElseThrow(() -> new UserNotFoundException("Пользователь с id " + id + " не найден"));
    return userMapper.toDto(user);
  }
}
