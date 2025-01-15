// We’ll be storing each customer visit as (timestamp, url, customerId) in a log file (one per day) for each site managed by AEM for obtaining business metrics. Your task is to find the list of loyal customers.  
// Loyal customer is a customer who visits at least 2 unique pages, and visits on multiple days. You’re given with 2 days of log files for one of our customers, your task is to find the loyal customers list and print it. 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LoyalCustomer {

    class Customer {
        String id;
        Date date;
        String url;

        public String getId() {
            return id;
        }

        public Date getDate() {
            return date;
        }

        public String getUrl() {
            return url;
        }
    }
    
    public List<Customer> readFile(String filePath, String sep) {
        List<Customer> list = new java.util.ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(sep);

                for (String word : words) {
                    Customer c = new Customer();
                    c.id = words[2];
                    c.date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(words[0]);
                    c.url = words[1];

                    list.add(c);
                }
            }

            return list;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<String> findLoyalCustomers(List<Customer> customers) {

        Map<String, Set<String>> customerPages = new HashMap<>();
        Map<String, Set<String>> customerDays = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (Customer customer : customers) {
            String customerId = customer.getId();
            String url = customer.getUrl();
            String day = sdf.format(customer.getDate());

            customerPages.computeIfAbsent(customerId, k -> new HashSet<>()).add(url);
            customerDays.computeIfAbsent(customerId, k -> new HashSet<>()).add(day);
        }

        List<String> loyalCustomers = new ArrayList<>();
        for (String customerId : customerPages.keySet()) {
            if (customerPages.get(customerId).size() >= 2 && customerDays.get(customerId).size() > 1) {
                loyalCustomers.add(customerId);
            }
        }

        return loyalCustomers;

    }

    public static void main(String[] args) {
        LoyalCustomer i = new LoyalCustomer();
        List<Customer> customers = new ArrayList<>();
        customers.addAll(i.readFile("logfile_01_06_2025.log", ","));
        customers.addAll(i.readFile("logfile_01_07_2025.log", ","));

        List<String> loyalCustomers = i.findLoyalCustomers(customers);
        System.out.println("Loyal Customers: " + loyalCustomers);
    }
}


