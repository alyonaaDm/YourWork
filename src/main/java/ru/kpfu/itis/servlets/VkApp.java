package ru.kpfu.itis.servlets;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.responses.GetResponse;

import java.util.List;
import java.util.stream.Collectors;

public class VkApp {
    public static void main(String[] args) {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);

      //создадим ссылку
        // https://oauth.vk.com/authorize?client_id=7994485&redirect_uri=http://ourlocalhost&scope=wall&scope=friends&v=5.131
        UserActor actor = new UserActor(213998045, "8ac7f666e4db762a80ee5e745ade0027e0749515ead47c3c316c233a198d54b273576f31f568400badbe0");

        try {
            List<Integer> friendIds = vk.friends().getOnline(actor).execute();
            System.out.println(friendIds.toString());
            List<GetResponse> users = vk.users().get(actor)
                    .userIds(friendIds.stream().map(userId -> userId.toString()).collect(Collectors.toList()))
                    .fields(Fields.EDUCATION)
                    .execute();

            for (GetResponse user: users) {
                System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getFacultyName());
            }



      } catch (ClientException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }


    }
    }
