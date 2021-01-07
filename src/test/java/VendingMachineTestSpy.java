import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class VendingMachineTestSpy {

    Box box;
    CashBox cashBox;
    VendingMachine vm;

    @BeforeEach
    void setUp(){
        box = Mockito.spy(Box.class);
        cashBox = Mockito.spy(CashBox.class);
        vm = new VendingMachineImpl(cashBox, new Box[]{box});

    }
    @Test
    public void enoughmoneytest() throws BoxEmptyException, NotEnoughMoneyException {
        vm.selectItem(0);

        Mockito.verify(box).getPrice();
        Mockito.verify(cashBox).getCurrentAmount();

    }
}