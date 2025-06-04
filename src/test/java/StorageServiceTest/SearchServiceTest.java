package StorageServiceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    public void givenEmptyStorage_whenNotFind_thenReturnEmptyList() {

        Mockito.when(storageService.getAllSearchable()).thenReturn(Collections.emptyList());

        Assertions.assertEquals(Collections.emptyList(), searchService.search("огурец"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"помидор", "банан", "курица"})

    public void givenEmptyStorage_whenFindOther_thenReturnList() {

        Mockito.when(storageService.getAllSearchable()).thenReturn(Collections.emptyList());

        Assertions.assertEquals(Collections.emptyList(), searchService.search("огурец"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"помидор", "банан", "курица"})

    public void givenEmptyStorage_whenFind_thenReturnList() {

        Mockito.when(storageService.getAllSearchable()).thenReturn(Collections.emptyList());

        Assertions.assertEquals(Collections.emptyList(), searchService.search("курица"));
    }


}
