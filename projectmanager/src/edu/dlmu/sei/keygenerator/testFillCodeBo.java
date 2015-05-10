package edu.dlmu.sei.keygenerator;

public class testFillCodeBo {


	public static void main(String[] args) {

		FillCodeBO bo= new FillCodeBO("IMP_certificatebattery","certificatebatteryno","BA4700606",4,"TE","certificatebatteryid",new Long(142));
		bo.execute();
	}

}
