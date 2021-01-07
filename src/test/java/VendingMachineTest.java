import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    VendingMachine vm;
    CashBox cb;
    Box fb;
    Box [] boxes = new Box[2];

    @BeforeEach
    void setUp() {
        cb = new UnlimitedCashBox();
        fb = new FullBox();
        boxes[0] = fb;
        vm = new VendingMachineImpl(cb, boxes);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void enoughmoneytest() throws BoxEmptyException, NotEnoughMoneyException {
        vm.selectItem(0);
    }
}