package sec01.exam06;

import sec01.exam01.RemoteControl;
import sec01.exam04.Audio;
import sec01.exam04.Television;

public class MyClass {
	// �ʵ�
	RemoteControl rc = new Television();

	// ������
	MyClass() {

	}

	MyClass(RemoteControl rc) {
		this.rc = rc;
		rc.turnOn();
		rc.setVolume(5);
	}
	
	// �޼ҵ�
	void methodA() {
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
	}
	
	void methodB(RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(5);
	}
}