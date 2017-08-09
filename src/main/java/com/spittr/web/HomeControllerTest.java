package com.spittr.web;

import com.spittr.Spitter;
import com.spittr.Spittle;
import com.spittr.data.SpitterRepository;
import com.spittr.data.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.*;

import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Created by 高保红 on 2017/8/4.
 */

public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception{
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when( mockRepository.findSpittles( 238900  ,50 ) ).thenReturn(expectedSpittles);
        SpittleController controller = new SpittleController( mockRepository );
        MockMvc mockMvc = standaloneSetup( controller ).setSingleView(
                new InternalResourceView( "/WEB-INF/views/spittles.jsp" ) ).build();
        mockMvc.perform( get( "/spittles?max=238900&count=50" ) )
                .andExpect( view().name( "spittles" ) )
                .andExpect( model().attributeExists( "spittleList" ) )
                .andExpect( model().attribute( "spittleList",hasItems(expectedSpittles.toArray()) ) );
    }

    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i=0;i<count;i++){
            spittles.add( new Spittle( "Spittle "+i,new Date( ) ));
        }
        return spittles;
    }

    @Test
    public void testSpittle() throws Exception{
        Spittle expectedSpittle = new Spittle("Hello",new Date());
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle",expectedSpittle));
    }

    @Test
    public void shouldShowRegistration() throws Exception{
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception{
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer","24hours","Jack","Bauer");
        Spitter saved = new Spitter(24L,"jbauer","24hours","Jack","Bauer");
        when(mockRepository.save(unsaved)).thenReturn(saved);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/spitter/register")
                .param("firstName","Jack")
                .param("lastName","Bauer")
                .param("userName","jbauer")
                .param("password","24hours"))
        .andExpect(redirectedUrl("/spitter/jbauer"));
        verify(mockRepository,atLeastOnce()).save(unsaved);


    }
}
