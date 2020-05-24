package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore store_1;
  private TorpedoStore store_2;
  private GT4500 gt_1;
  private GT4500 gt_2;

 
  
  
  @BeforeEach
  public void init(){
    this.ship = new GT4500();
    store_1 = mock(TorpedoStore.class);
    gt_1 = new GT4500(store_1);
    gt_2 = new GT4500(store_1);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(store_1.fire(1)).thenReturn(true);
    // Act
     boolean result = gt_1.fireTorpedo(FiringMode.SINGLE);
    // Assert
    assertEquals(true, result);
   verify(store_1, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(store_1.fire(1)).thenReturn(true);
    when(store_2.fire(1)).thenReturn(true);
    // Act
    boolean result = gt_1.fireTorpedo(FiringMode.ALL);
    boolean _result = gt_2.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    assertEquals(true, _result);
    verify(store_1, times(1)).fire(1);
    verify(store_2, times(1)).fire(1);

  }

  @Test
  public void fireTorpedo_Single_Success_WasPrimary(){
    // Arrange
    when(store_1.fire(1)).thenReturn(true);
    when(store_2.fire(1)).thenReturn(true);


    // Act
    boolean result = gt_1.fireTorpedo(FiringMode.SINGLE);
    boolean first = store_2.isEmpty();

    // Assert
    assertEquals(true, result);
    assertEquals(true, first);
    verify(store_1, times(1)).fire(1);

  }
  @Test
  public void fireTorpedo_Single_Another_Store(){
    // Arrange
    when(store_1.fire(1)).thenReturn(true);
    when(store_2.fire(1)).thenReturn(true);


    // Act
    boolean result = store_1.isEmpty();


    // Assert
    assertEquals(true, result);

    verify(store_2, times(1)).fire(1);

  }
  @Test
  public void fireTorpedo_Single_Not_Try_Other(){
    // Arrange
    when(store_1.fire(1)).thenReturn(true);
     when(store_2.fire(1)).thenReturn(true);


    // Act
    boolean result = store_1.isEmpty();


    // Assert
    assertEquals(true, result);

    verify(store_1, times(1)).fire(1);

  }

  @Test
  public void fireTorpedo_ALl(){
    // Arrange
    when(store_1.fire(1)).thenReturn(true);
    when(store_2.fire(1)).thenReturn(true);


    // Act
    boolean result = gt_1.fireTorpedo(FiringMode.ALL);


    // Assert
    assertEquals(true, result);

    verify(store_1, times(1)).fire(1);
    verify(store_2, times(1)).fire(1);
  }

  public void fireTorpedo_Single_Alter(){
    // Arrange
    when(store_1.fire(1)).thenReturn(true);
    when(store_2.fire(1)).thenReturn(true);


    // Act
    boolean result = gt_1.fireTorpedo(FiringMode.SINGLE);


    // Assert
    assertEquals(true, result);

    verify(store_1, times(1)).fire(1);
    verify(store_2, times(1)).fire(1);
  }
}
