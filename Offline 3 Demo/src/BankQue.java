
import java.util.Scanner;

public class BankQue {
   static class Customer
    {
        private int enter_time;
        private int service_time;

        public int getEnter_time() {
            return enter_time;
        }

        public void setEnter_time(int enter_time) {
            this.enter_time = enter_time;
        }

        public int getService_time() {
            return service_time;
        }

        public void setService_time(int service_time) {
            this.service_time = service_time;
        }
        public Customer(int enter_time,int service_time)
        {
            this.enter_time=enter_time;
            this.service_time=service_time;
        }
        public Customer()
        {

        }

        @Override
        public String toString() {
            return "Customer{" +
                    "enter_time=" + enter_time +
                    ", service_time=" + service_time +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int no_of_customers = inp.nextInt();
        //LinQue<Customer> Booth1 = new LinQue<>(no_of_customers);
        //LinQue<Customer> Booth2 = new LinQue<>(no_of_customers);
        ArrQue<Customer> Booth1 = new ArrQue<>(no_of_customers);
        ArrQue<Customer> Booth2 = new ArrQue<>(no_of_customers);
        int Booth1_time, Booth2_time;
        Booth1_time = 0;
        Booth2_time = 0;
        Customer Service_taker;
        int entry_time, service_time;
        for (int i = 0; i < no_of_customers; i++) {
            entry_time = inp.nextInt();
            service_time = inp.nextInt();
            Service_taker = new Customer(entry_time, service_time);
            if (Booth1.length() == 0 && Booth2.length() == 0) {
                if (Booth1_time <= entry_time) {
                    Booth1.enqueue(Service_taker);
                } else if (Booth2_time <= entry_time) {
                    Booth2.enqueue(Service_taker);
                } else {
                    Booth1.enqueue(Service_taker);
                }
            } else if (Booth1.length() <= Booth2.length()) {
                Booth1.enqueue(Service_taker);
            } else {
                Booth2.enqueue(Service_taker);
            }
            while (((Booth1.length() != 0) && (Booth1_time <= entry_time)) || ((Booth2.length() != 0) && (Booth2_time <= entry_time))) {
                if ((Booth1.length() != 0) && (Booth1_time <= Service_taker.getEnter_time())) {
                    Service_taker = Booth1.dequeue();
                    if (Booth1_time < Service_taker.getEnter_time()) {
                        Booth1_time = Service_taker.getEnter_time() + Service_taker.getService_time();
                    } else {
                        Booth1_time += Service_taker.getService_time();
                    }
                }
                if ((Booth2.length() != 0) && (Booth2_time <= entry_time)) {
                    Service_taker = Booth2.dequeue();
                    if (Booth2_time < Service_taker.getEnter_time()) {
                        Booth2_time = Service_taker.getEnter_time() + Service_taker.getService_time();
                    } else {
                        Booth2_time += Service_taker.getService_time();
                    }
                }
                while ((Booth1.length() < Booth2.length()) && (Booth2.length() != 0)) {
                    Booth1.enqueue(Booth2.leaveQueue());
                }
                while ((Booth2.length() +1< Booth1.length()) && (Booth1.length() != 0)) {
                    Booth2.enqueue(Booth1.leaveQueue());
                }

            }
        }
        entry_time = Math.min(Booth1_time, Booth2_time);
        while (Booth1.length() != 0 || Booth2.length() != 0) {
            if ((Booth1.length() != 0) && (Booth1_time <= entry_time)) {
                Service_taker = Booth1.dequeue();
                if (Booth1_time < Service_taker.getEnter_time()) {
                    Booth1_time = Service_taker.getEnter_time() + Service_taker.getService_time();
                } else {
                    Booth1_time += Service_taker.getService_time();
                }
            }
            if ((Booth2.length() != 0) && (Booth2_time <= entry_time)) {
                Service_taker = Booth2.dequeue();
                if (Booth2_time < Service_taker.getEnter_time()) {
                    Booth2_time = Service_taker.getEnter_time() + Service_taker.getService_time();
                } else {
                    Booth2_time += Service_taker.getService_time();
                }
            }
            while ((Booth1.length() < Booth2.length()) && (Booth2.length() != 0)) {
                Booth1.enqueue(Booth2.leaveQueue());
            }
            while ((Booth2.length() +1< Booth1.length()) && (Booth1.length() != 0)) {
                Booth1.enqueue(Booth1.leaveQueue());
            }
            entry_time++;
        }
        System.out.println(Booth1_time);
        System.out.println(Booth2_time);

    }
}
