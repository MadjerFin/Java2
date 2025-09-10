package com.example.java_advanced.gateways;

import com.example.java_advanced.services.AlunoDataServiceInterface;
import com.example.java_advanced.services.ConcatIdToAlunoService;
import com.example.java_advanced.services.ListAlunosService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class AlunoControllerTest {
    @InjectMocks
    private AlunoController alunoController;


    @Mock
    private ConcatIdToAlunoService concatIdToAlunoService;
    @Mock
    private ListAlunosService listAlunosService;
    @Mock
    private AlunoDataServiceInterface createAlunoService;
    @Mock
    private AlunoDataServiceInterface updateAlunoService;

    @Test
    void getAlunoTest () {
        String expected = "a-string";
        Mockito.when(concatIdToAlunoService.execute(Mockito.anyString())).thenReturn(expected);

        String actual = alunoController.getAluno(expected);

        assertEquals(expected, actual);
        Mockito.verify(concatIdToAlunoService,
                Mockito.times(1)).execute(Mockito.anyString());

    }

}