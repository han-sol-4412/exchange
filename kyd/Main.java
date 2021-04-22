package kyd;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		// 환율계산기
		Input in = new Input();
		Rate rateSelect = new Rate();
		Calculator cal = new Calculator();
		FileOutput fw = new FileOutput();
		
		int choice;
		int input ;
		do {
				input = in.getInput();
				choice = in.getChice();
				
				double rate = rateSelect.rate(choice) ;
				
				int exchange_moneyInt = cal.getExchange_moneyInt(input, rate);
				int wonChange = cal.getWonChange(input, rate, exchange_moneyInt);
				cal.exchange(choice, exchange_moneyInt);
				cal.change(wonChange);
				fw.headerWrite();
				fw.dataWrite(choice, input, exchange_moneyInt, wonChange);
				
		}while(input != ConstValue.EX_TYPE_EXIT);
		fw.fileClose();
	}
}

