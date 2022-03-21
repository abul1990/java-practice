public class DecoratorPattern {
    public static void main(String[] args) {
        Dress basicDress = new BasicDress();
        basicDress.printDress();

        Dress casual = new Casual(new Fancy(new BasicDress()));
        casual.printDress();
    }
}

interface Dress {
    void printDress();
}

class BasicDress implements Dress {

    @Override
    public void printDress() {
        System.out.println("Basic Dress");
    }
}

class DressDecorator implements Dress {
    private Dress dress;

    public DressDecorator(Dress dress) {
        this.dress = dress;
    }

    @Override
    public void printDress() {
        this.dress.printDress();
    }
}

class Casual extends DressDecorator {

    public Casual(Dress dress) {
        super(dress);
    }

    @Override
    public void printDress() {
        super.printDress();
        System.out.println("Casual Dress");
    }
}

class Fancy extends DressDecorator {

    public Fancy(Dress dress) {
        super(dress);
    }

    @Override
    public void printDress() {
        super.printDress();
        System.out.println("Fancy Dress");
    }
}
