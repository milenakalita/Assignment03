package JavaAss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class NewUserModelTest {

    NewUserModel model;

    @BeforeEach
    void setUp() {
        model = new NewUserModel();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123@gmail.com", "milena@123.ie", "m.k@e.net"})
    public void acceptValidEmail(String email){
        model.setEmail(email);
        assertEquals(email, model.getEmail());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "hi", "m.kalita@com", "gmail.com", "@outlook", "@eu."})
    public void rejectInvalidEmail(String email) {
        assertThrows(IllegalArgumentException.class, () -> {model.setEmail(email);}, "email should have a proper format");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello1*", "hel1l&O", "h1e2l*l0o3o5"})
    public void acceptValidPassword(String password){
        model.setPassword(password);
        assertEquals(password, model.getPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "hello12", "123*456", "HELLOOO", "HELLOO1"})
    public void rejectInvalidPassword(String password){
        assertThrows(IllegalArgumentException.class, () -> {model.setPassword(password);}, "Password must meet specific requirements");

    }

}