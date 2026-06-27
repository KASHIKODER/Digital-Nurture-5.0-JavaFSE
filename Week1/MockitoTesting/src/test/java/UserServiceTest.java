import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    // Mock object — fake UserRepository
    @Mock
    private UserRepository userRepository;

    // Real object — UserService with mock injected
    @InjectMocks
    private UserService userService;

    // ===== Ex 1: Mocking and Stubbing =====
    @Test
    void testGetUser_Stubbing() {
        // ARRANGE — stub banao
        // "jab findUserById(1) call ho toh 'Suyash' return karo"
        when(userRepository.findUserById(1)).thenReturn("Suyash");

        // ACT
        String result = userService.getUser(1);

        // ASSERT
        assertEquals("Suyash", result, "User should be Suyash");
        System.out.println("Stubbing test passed: " + result);
    }

    @Test
    void testGetUser_ReturnsNull_WhenNotFound() {
        // Stub — unknown id ke liye null return karo
        when(userRepository.findUserById(99)).thenReturn(null);

        String result = userService.getUser(99);

        assertNull(result, "Unknown user should return null");
        System.out.println("Null stubbing test passed");
    }

    @Test
    void testCreateUser_Stubbing() {
        // Stub — saveUser true return kare
        when(userRepository.saveUser("Karan")).thenReturn(true);

        boolean result = userService.createUser("Karan");

        assertTrue(result, "User should be created successfully");
        System.out.println("Create user test passed: " + result);
    }

    // ===== Ex 2: Verifying Interactions =====
    @Test
    void testGetUser_VerifyInteraction() {
        // ARRANGE
        when(userRepository.findUserById(1)).thenReturn("Suyash");

        // ACT
        userService.getUser(1);

        // VERIFY — findUserById(1) exactly ek baar call hua?
        verify(userRepository, times(1)).findUserById(1);
        System.out.println("Verify interaction test passed");
    }

    @Test
    void testCreateUser_VerifyInteraction() {
        when(userRepository.saveUser("Suyash")).thenReturn(true);

        userService.createUser("Suyash");

        // VERIFY — saveUser called once with "Suyash"
        verify(userRepository, times(1)).saveUser("Suyash");
        System.out.println("Verify saveUser test passed");
    }

    @Test
    void testCreateUser_EmptyName_NeverCallsRepo() {
        // Empty name — repository call hi nahi hona chahiye
        userService.createUser("");

        // VERIFY — saveUser kabhi call nahi hua
        verify(userRepository, never()).saveUser(anyString());
        System.out.println("Never called test passed");
    }

    // Void method stubbing
    @Test
    void testVoidMethod_Stubbing() {
        // ARRANGE — doNothing for void methods
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findUserById(1)).thenReturn("Test");

        // ACT + ASSERT
        assertEquals("Test", mockRepo.findUserById(1));
        System.out.println("Void method test passed");
    }
}