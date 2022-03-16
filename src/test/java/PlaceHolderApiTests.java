import util.BaseTest;
import model.Post;
import org.junit.jupiter.api.Test;


public class PlaceHolderApiTests extends BaseTest {



    @Test
    public void createPost() {
        Post postCreation=new Post();
        postCreation.post();

    }

    @Test
    public void checkEmailInEachComment(){

        EmailValidation validateEmail=new EmailValidation();
        validateEmail.emailvalidationIncomments();

    }

    @Test
    public void searchForUserName(){

        SearchUserName user=new SearchUserName();
        user.searchuser();
    }


    @Test
    public void checkSthInEachUserPost(){

        CheckInEachUserPost usercheck= new CheckInEachUserPost();
        usercheck.checkSthInEachUserPost();

    }
}
