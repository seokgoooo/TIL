package practice;

class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }
}

class UpgradeCalculator extends Calculator {
	public UpgradeCalculator() {
	}
	
	void minus(int val) {
		super.value -= val;
	}
}
public class Sample {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.add(10);
        System.out.println(cal.getValue());  // 10 출력
        
        UpgradeCalculator cal2 = new UpgradeCalculator();
        cal2.add(10);
        cal2.minus(3);
        System.out.println(cal2.getValue());  // 10에서 7을 뺀 3을 출력
    }
}