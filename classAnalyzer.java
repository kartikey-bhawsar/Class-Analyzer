import java.lang.reflect.*;
class Analyzer
{
public static void main(String [] data)
{
if(data.length!=1)
{
System.out.println("Usage: java classAnalyzer.java class_name");
return;
}
String classToAnalyze=data[0];
try
{
Class c=Class.forName(classToAnalyze); //Their is a class named Class in java. 
System.out.println("Class Name (Package name included): "+c.getName()); 
System.out.println("Simple Name: "+c.getSimpleName());
Method methods[];
methods=c.getDeclaredMethods();
System.out.println("Number of methods: "+methods.length);
Method m;
String methodName;
Class methodReturnType;
Class parameters[];
for(int e=0;e<methods.length;e++)
{
m=methods[e];
methodName=m.getName();
System.out.println("Name of method: "+methodName);
methodReturnType=m.getReturnType();
System.out.println("Return type of method: "+methodReturnType.getName());
parameters=m.getParameterTypes();
System.out.println("Number of parameters: "+parameters.length);
for(int j=0;j<parameters.length;j++)
{
System.out.printf("Parameter no. %d, Type %s\n",j+1,parameters[j].getName());
}
}
System.out.println("FIELDS FIELDS FIELDS .....");
Field fields[];
fields=c.getDeclaredFields();
System.out.println("Number of fields: "+fields.length);
Field f;
String fieldName;
Class fieldType;
for(int e=0;e<fields.length;e++)
{
f=fields[e];
fieldName=f.getName();
fieldType=f.getType();
System.out.printf("Field No. %d, Field Name: %s, Type: %s\n",e+1,fieldName,fieldType.getName());
}
}catch(ClassNotFoundException cnfe)
{
System.out.println("Class "+cnfe.getMessage()+" not found");
}
}
}