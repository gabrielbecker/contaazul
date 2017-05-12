package mars;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import mars.control.AppController;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BaseTest {
		
	@Autowired
    private TestRestTemplate restTemplate;
	@Autowired
	private AppController appController;
	
	protected MockMvc mockMvc;
	
	private final String address = "http://localhost:8080/rest/mars/";

	@Before
    public void setupMockMvc() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(appController).build();
    }
	
	@Test
	public void testObjects() throws Exception {
		assertNotNull(this.restTemplate);
		assertNotNull(this.appController);
		assertNotNull(this.mockMvc);

	}

	//Testes Corretos
	@Test
	public void testRotationRight() throws Exception {
		String result = "(2,0,S)";
		String moveSet = "MMRMMRMM";

		mockOk(result, moveSet);
	}
	
	@Test
	public void testMoveLeft() throws Exception {
		String result = "(0,2,W)";
		String moveSet = "MML";

		mockOk(result, moveSet);
	}
	
	@Test
	public void testMoveRightTwice() throws Exception {
		String result = "(0,2,W)";
		String moveSet = "MML";

		mockOk(result, moveSet);
		
		mockOk(result, moveSet);
	}
	
	@Test
	public void testGoToTopRightThroughMiddle() throws Exception {
		String result = "(4,4,N)";
		String moveSet = "MRMLMRMLMRMLMRML";
		
		mockOk(result, moveSet);
	}
		
	//Movimentos com erro
	@Test
	public void testInvalidCommand() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "AAA";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testInvalidPosition() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "MMMMMMMMMMMMMMMMMMMMMMMM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeLeft0() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "LM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeLeft1() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "MLM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeLeft2() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "MMLM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeLeft3() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "MMMLM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeLeft4() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "MMMMLM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeRight0() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "RMMMMM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeRight1() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "MRMMMMM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeRight2() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "MMRMMMMM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeRight3() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "MMMRMMMMM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeRight4() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "MMMMRMMMMM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeUp0() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "MMMMM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeUp1() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "RMLMMMMM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeUp2() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "RMMLMMMMM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeUp3() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "RMMMLMMMMM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeUp4() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "RMMMMLMMMMM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeDown0() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "LLM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeDown1() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "RMRM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeDown2() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "RMMRM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeDown3() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "RMMMRM";

		mockFail(result, moveSet);
	}
	
	@Test
	public void testEscapeDown4() throws Exception {
		String result = "400 Bad Request";
		String moveSet = "RMMMMRM";

		mockFail(result, moveSet);
	}

	private void mockOk(String result, String moveSet) throws Exception {
		this.mockMvc.perform(post(address+moveSet)
				.content(MediaType.TEXT_PLAIN_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().string(result))
				.andReturn();
	}
	
	private void mockFail(String result, String moveSet) throws Exception {
		this.mockMvc.perform(post(address+moveSet)
				.content(MediaType.TEXT_PLAIN_VALUE))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(result))
				.andReturn();
	}
	
}
