import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

 class missed_call
{
  String name,time;
   long number;
   missed_call(long number,String time){
   this.name="private";
   this.number=number;
   this.time=time;
   }
   missed_call(String name,long number,String time)
   {
    this.name=name;
    this.time=time;
    this.number=number;
   }

  public void setname(String name)
  {
  this.name=name;
}
}

 class phone_call
 {
      String name,time;
      long number;
   phone_call(String name,long number)
   {
    this.name=name;
    this.number=number;
   }

 }

 public class telephone
 {
     public static void main(String[] args)throws IOException
     {
         ArrayList<missed_call> missed_calls=new ArrayList<>();
         HashMap<Integer,phone_call> phone_calls=new HashMap<>();
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         String name_list[]={"Ayush","Affan","Keshav","Arjun","Zee","Bagri","Faiz"};
         Calendar cal = Calendar.getInstance();
         SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
         Random r=new Random();
         int i=0;
         for(String name:name_list)
         {
             phone_call m =new phone_call(name, r.nextInt(99999)+1);
             phone_calls.put(i,m);
             i++;
         }

         for(int k=0;k<3;k++)
         {
             phone_call p=new phone_call("private",r.nextInt(99999)+1);
             phone_calls.put(i,p);
             i++;
         }
         while(true)
         {
             System.out.println("\n 1. Add New Missed call \n 2.List missed calls \n 3.Delete missed call \n 4.Recall \n 4.Exit ");
             int choice=Integer.parseInt(br.readLine());
             if(missed_calls.size()>10)
             {
                 missed_calls.remove(0);
             }
             switch(choice)
             {
                 case 1:
                        int no=r.nextInt(i);
                        phone_call p=phone_calls.get(no);
                        if(!p.name.toLowerCase().equals("private")){
                            missed_call m=new missed_call(p.name.toLowerCase(),p.number,sdf.format(cal.getTime()));
                            System.out.println("\n Number :"+p.number+"\t Added");
                            missed_calls.add(m);
                        }
                        else
                        {
                            missed_call m=new missed_call(p.number,sdf.format(cal.getTime()));
                            missed_calls.add(m);
                            System.out.println("\n Number :"+p.number+"\t Added");
                        }
                        break;

                 case 2:
                        System.out.println("\n Your missed calls are");
                        for(int j=0;j<missed_calls.size();j++)
                        {
                               
                            missed_call m=missed_calls.get(j);
                            System.out.println("\nNumber:"+m.number);
                            System.out.println("\n 1.Delete call \n 2.Show next missed call \n 3.display call details \n 4.Exit");
                            int ch=Integer.parseInt(br.readLine());
                            switch(ch)
                            {
                                case 1:
                                      missed_calls.remove(j);
                                      System.out.println("\n Call Deleted");
                                      break;
                                case 2:continue;      
                                case 3:
                                      System.out.println("\n Name:"+m.name +"\n Number:"+m.number +"\n Time:"+m.time); 
                                      break;
                                case 4:break;      

                            }
                            if(j==missed_calls.size()-1)
                            {
                                System.out.println("\n No more calls to show");
                            } 
                            

                        }
                        break;
                        case 3:
                                System.out.println("\nEnter a number to delete");
                                long num=Long.parseLong(br.readLine());
                                int found=0;
                                for(int j=0;j<missed_calls.size();j++)
                                {
                                    if(missed_calls.get(j).number == num)
                                    {
                                        missed_calls.remove(j);
                                        found=1;
                                        System.out.println("Number Deleted");
                                        break;
                                    }
                                   
                                }
                                 if(found==0)
                                    {
                                        System.out.println("\n Number not found");
                                    }
                                    break;
                        case 4:
                                System.out.println("\n Recalling");
                                for(int j=0;j<missed_calls.size();j++)
                                {
                                    System.out.println("\n Calling \t"+missed_calls.get(j).number);
                                    
                                }
                                break;
                        case 5: 
                            System.exit(0);

             }

         }

     }
 }
