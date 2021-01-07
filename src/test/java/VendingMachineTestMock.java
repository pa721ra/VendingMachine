import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTestMock {

    Box box;
    CashBox cashBox;
    VendingMachine vm;

    @BeforeEach
    void setUp(){
        box = Mockito.mock(Box.class);
        cashBox = Mockito.mock(CashBox.class);
        vm = new VendingMachineImpl(cashBox, new Box[]{box});

    }
    @Test
    public void enoughmoneytest() throws BoxEmptyException, NotEnoughMoneyException {
        Mockito.when(box.isEmpty()).thenReturn(false);
        Mockito.when(box.getPrice()).thenReturn(1);
        Mockito.when(cashBox.getCurrentAmount()).thenReturn(2);
        vm.selectItem(0);

        Mockito.verify(box, Mockito.times(1)).releaseItem();
        Mockito.verify(cashBox, Mockito.times(1)).withdraw(1);
    }
}