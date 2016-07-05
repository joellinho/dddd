import java.util.Arrays;
import java.util.List;
import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import  org.hamcrest.Matcher;


public class DummyCollaboratorCallerTest {

	// Class under test
	private DummyCaller dummyCaller;
 
	@Mock
	private DummyCollaborator mockDummyCollaborator;
 
	@Captor
	private ArgumentCaptor<DummyCallback> dummyCallbackArgumentCaptor;
 
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dummyCaller = new DummyCaller(mockDummyCollaborator);
	}
	@Test
	public void testDoSomethingAsynchronouslyUsingDoAnswer() {
		final List<String> results = Arrays.asList("One", "Two", "Three");
		// Let's do a synchronous answer for the callback
		doAnswer(new Answer() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				((DummyCallback)invocation.getArguments()[0]).onSuccess(results);
				return null;
			}
		}).when(mockDummyCollaborator).doSomethingAsynchronously(
				any(DummyCallback.class));
 
		// Let's call the method under test
		dummyCaller.doSomethingAsynchronously();
 
		// Verify state and interaction
		verify(mockDummyCollaborator, times(1)).doSomethingAsynchronously(
				any(DummyCallback.class));
		assertThat(dummyCaller.getResult(), equals(results));
	}
}
