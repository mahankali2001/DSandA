package com.demo;
// import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProvisioningPayload {
    
    class IFN {
        String orgId;
        String FFId;
        FulfillmentItems fulfillmentItems;
    }

    class FulfillmentItems {
        String ItemId;
        String ItemName;
    }

    public IFN parseJSON(String jsonString) throws Exception {
        // Gson gson = new Gson();
        // return gson.fromJson(jsonString, IFN.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, IFN.class);
        // return null;
        
    }

    public static void main(String[] args) {
        String jsonString = "{\"orgId\":\"123\",\"FFId\":\"456\",\"fulfillmentItems\":{\"ItemId\":\"789\",\"ItemName\":\"ItemNameValue\"}}";
        
        ProvisioningPayload pp = new ProvisioningPayload();
        IFN ifn = null;
        try {
            ifn = pp.parseJSON(jsonString);
        }catch(Exception e) {
            System.out.println("exception:" + e.getStackTrace());
        }
        if(ifn != null) {
            System.out.println("OrgId: " + ifn.orgId);
            System.out.println("FFId: " + ifn.FFId);
            System.out.println("ItemId: " + ifn.fulfillmentItems.ItemId);
            System.out.println("ItemName: " + ifn.fulfillmentItems.ItemName);
        }
    }
}
