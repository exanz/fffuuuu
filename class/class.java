// Абстрактный суперкласс Supercar — верхний уровень иерархии
abstract class Supercar {
    private String brand;
    private String model;
    private int year;
    private int maxSpeedKmh;

    // Стандартный конструктор
    public Supercar() {
        brand = "Неизвестно";
        model = "Неизвестно";
        year = 0;
        maxSpeedKmh = 0;
    }

    // Параметризированный конструктор
    public Supercar(String b, String m, int y, int ms) {
        brand = b;        
        model = m;         
        year = y;          
        maxSpeedKmh = ms; 
    }

    // Копирующий конструктор
    public Supercar(Supercar ob) {
        brand = ob.brand;
        model = ob.model;
        year = ob.year;
        maxSpeedKmh = ob.maxSpeedKmh;
    }

    // Методы доступа
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public int getMaxSpeedKmh() { return maxSpeedKmh; }

    // Метод для показа общей информации
    public void showBaseInfo() {
        System.out.println("Марка: " + brand + ", Модель: " + model);
        System.out.println("Год выпуска: " + year + ", Макс. скорость: " + maxSpeedKmh + " км/ч");
    }

    // Абстрактный метод
    abstract String getEngineType();
}

// Подкласс FerrariCar
class FerrariCar extends Supercar {
    private String signatureFeature;
    private int horsePower;

    // Стандартный конструктор
    public FerrariCar() {
        super("Ferrari", "Неизвестно", 0, 0);
        signatureFeature = "Не указана";
        horsePower = 0;
    }

    // Параметризированный конструктор 
    public FerrariCar(String m, int y, int ms, String sf, int hp) {
        super("Ferrari", m, y, ms);
        signatureFeature = sf;
        horsePower = hp;
    }

    // Копирующий конструктор
    public FerrariCar(FerrariCar ob) {
        super(ob);
        signatureFeature = ob.signatureFeature;
        horsePower = ob.horsePower;
    }

    public String getSignatureFeature() { return signatureFeature; }
    public int getHorsePower() { return horsePower; }

    public void displayFerrariFeature() {
        System.out.println("Особенность Ferrari: " + signatureFeature + ", Мощность: " + horsePower + " л.с.");
    }

    public String getEngineType() {
        return "V8 Twin-Turbo";
    }
}

// Подкласс LamborghiniCar
class LamborghiniCar extends Supercar {
    private boolean hasScissorDoors;
    private String driveType;

    // Стандартный конструктор
    public LamborghiniCar() {
        super("Lamborghini", "Неизвестно", 0, 0);
        hasScissorDoors = true;
        driveType = "AWD";
    }

    // Параметризированный конструктор
    public LamborghiniCar(String m, int y, int ms, boolean hsd, String dt) {
        super("Lamborghini", m, y, ms);
        hasScissorDoors = hsd;
        driveType = dt;
    }

    // Копирующий конструктор
    public LamborghiniCar(LamborghiniCar ob) {
        super(ob);
        hasScissorDoors = ob.hasScissorDoors;
        driveType = ob.driveType;
    }

    public boolean hasScissorDoors() { return hasScissorDoors; }
    public String getDriveType() { return driveType; }

    public void displayLamborghiniDetails() {
        System.out.println("Двери-ножницы: " + (hasScissorDoors ? "Да" : "Нет") + ", Тип привода: " + driveType);
    }

public String getEngineType() {
        return "V10 Naturally Aspirated";
    }
}

// Главный класс для демонстрации иерархии
class SupercarDemoNoThis {
    public static void main(String[] args) {
        Supercar[] myGarage = new Supercar[4];

        myGarage[0] = new FerrariCar("SF90 Stradale", 2023, 340, "Гибридная система HY-KERS", 1000);
        myGarage[1] = new LamborghiniCar("Aventador SVJ", 2022, 350, true, "AWD");
        myGarage[2] = new FerrariCar("Roma", 2022, 320, "Элегантный Gran Turismo", 620);
        myGarage[3] = new LamborghiniCar("Huracan Tecnica", 2023, 325, false, "RWD");

        for (int i = 0; i < myGarage.length; i++) {
            System.out.println("Тип двигателя: " + myGarage[i].getEngineType());
            myGarage[i].showBaseInfo();

            if (myGarage[i] instanceof FerrariCar) {
                ((FerrariCar)myGarage[i]).displayFerrariFeature();
            } else if (myGarage[i] instanceof LamborghiniCar) {
                ((LamborghiniCar)myGarage[i]).displayLamborghiniDetails();
            }
            System.out.println();
        }
    }
}
