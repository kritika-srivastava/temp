package com.stackroute.oops;

public class VehicleService {

  /*
    create a Car object and return it
     */
  public Car createCar(String name, String modelName, String type) {
    return new Car(name, modelName, type);
  }

  /*
    create a bike object and return it
     */
  public Bike createBike(String name, String modelName, String type) {
    return new Bike(name, modelName, type);
  }

  /*
    Method should compare the speed only if the vehicle is of "SPORTS" type.
    Method should return 0 when speeds are equal otherwise should return maximum vehicle speed.
    Method returns -1 if the type is not "SPORTS"
    */
  public int compareMaxSpeed(Vehicle first, Vehicle second) {
    /*
        Vehicle objects should be downcasted to their respective concrete types
    */
	  int s1=0,s2=0;
	if(first.getClass()==Car.class && second.getClass()==Car.class) {
		Car f=(Car)first;
		Car s=(Car)second;
		if(f.type.equalsIgnoreCase("sports") && s.type.equalsIgnoreCase("sports"))
		{
			s1=f.maxSpeed(f.type);
			s2=s.maxSpeed(s.type);
			
			return s1==s2 ? 0:Math.max(s1, s2);
		}
	}
	else if(first.getClass()==Car.class && second.getClass()==Bike.class) {
		Car f=(Car)first;
		Bike s=(Bike)second;
		if(f.type.equalsIgnoreCase("sports") && s.type.equalsIgnoreCase("sports"))
		{
			s1=f.maxSpeed(f.type);
			s2=s.maxSpeed(s.type);
			System.out.println(s1+" "+s2);
			return s1==s2 ? 0:Math.max(s1, s2);
		}
	}
	else if(first.getClass()==Bike.class && second.getClass()==Car.class) {
		Bike f=(Bike)first;
		Car s=(Car)second;
		if(f.type.equalsIgnoreCase("sports") && s.type.equalsIgnoreCase("sports"))
		{
			s1=f.maxSpeed(f.type);
			s2=s.maxSpeed(s.type);
			
			return s1==s2 ? 0:Math.max(s1, s2);
		}
	}
	else if(first.getClass()==Bike.class && second.getClass()==Bike.class) {
		Bike f=(Bike)first;
		Bike s=(Bike)second;
		if(f.type.equalsIgnoreCase("sports") && s.type.equalsIgnoreCase("sports"))
		{
			s1=f.maxSpeed(f.type);
			s2=f.maxSpeed(s.type);
			
			return s1==s2 ? 0:Math.max(s1, s2);
		}
	}
    return -1;
  }
}
