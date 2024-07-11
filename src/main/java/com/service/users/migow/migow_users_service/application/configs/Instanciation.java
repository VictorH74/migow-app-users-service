package com.service.users.migow.migow_users_service.application.configs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.CreateManyFollowerUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.CreateManyUserUseCase;
import com.service.users.migow.migow_users_service.domain.entities.Follower;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.entities.pks.FollowerPK;

@Configuration
public class Instanciation implements CommandLineRunner {

        @Autowired
        CreateManyUserUseCase createManyUserUseCase;
        @Autowired
        CreateManyFollowerUseCase createManyFollowerUseCase;

        @Override
        public void run(String... args) throws Exception {
                User[] users = new User[] {
                                new User(UUID.fromString("fc7dc70e-067b-414d-8a9d-35a2bb5c8736"), "vyctor7410",
                                                "123456789", "Victor Almeida", "victor@gmail.com", null, null),
                                new User(UUID.fromString("9bca54b4-6cfe-4f76-8a11-def9c829e627"), "nickT_776",
                                                "123456789", "Nikolas Tesla", "nick@gmail.com", null, null),
                                new User(UUID.fromString("90f7c337-cc45-4af6-82df-13a7c8cad090"), "mary-988",
                                                "123456789", "Marina Silva", "mari@gmail.com",
                                                "https://th.bing.com/th/id/OIP.h04o3WE6Gle5wjqYLzhATwHaHa?pid=ImgDet&w=198&h=198&c=7",
                                                null),
                                new User(UUID.fromString("d3ead047-ac78-4c2e-b6f4-dd3e306b58bb"), "jeorge421",
                                                "123456789", "Jeorge Borges",
                                                "j.borges@gmail.com",
                                                "https://th.bing.com/th/id/OIP.kLuVl7_2soHqjgecM56X2AHaLL?w=202&h=305&c=7&r=0&o=5&pid=1.7",
                                                null),
                                new User(UUID.fromString("7198b869-bf2e-4f73-bb31-981961b3bd5c"), "gabby_sousa78",
                                                "123456789", "Gabrielly Sousa",
                                                "gabbs@gmail.com", null,
                                                null),
                                new User(UUID.fromString("e8ba5172-a8a6-4298-80a4-dab22029b951"), "joice_p@98",
                                                "123456789", "Joice Pereira", "joy@gmail.com",
                                                "https://th.bing.com/th/id/R.da2e546841da40cdcf60061743233500?rik=IeO7Sr%2fkUW54wQ&riu=http%3a%2f%2fwww.venmond.com%2fdemo%2fvendroid%2fimg%2favatar%2fbig.jpg&ehk=JihI5nQ0BOd0W%2bZVhtIWmqwac0NMyRMOV7%2bzryywg%2fg%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1",
                                                null),
                                new User(UUID.fromString("94191aca-bc3e-45e8-845b-e5df73957f48"), "Gvana123",
                                                "123456789", "Geovana Bragas",
                                                "g-bragas@gmail.com", null, null),
                                new User(UUID.fromString("1e0a91e8-cc47-4e3b-acb7-31b1349257a9"), "math#Silva",
                                                "123456789", "Matheus Silva",
                                                "math@gmail.com", null, null),
                                new User(UUID.fromString("b68180aa-d790-4a17-85bc-972cd2644655"), "Lidia123",
                                                "123456789", "Lidia Nogueira",
                                                "lidia@gmail.com",
                                                "https://fastly.picsum.photos/id/454/200/200.jpg?hmac=N13wDge6Ku6Eg_LxRRsrfzC1A4ZkpCScOEp-hH-PwHg",
                                                null),
                                new User(UUID.fromString("32ec771a-f70c-4b13-a231-234b32fc2fee"), "karlos7999",
                                                "123456789", "Karlos Almendra",
                                                "karlos@gmail.com", null, null),
                                new User(UUID.fromString("9dfdb019-59f1-4742-beec-cf03054178c5"), "nicolinha578",
                                                "123456789", "Nicole Dias",
                                                "nic-dias@gmail.com", null, null),
                };

                List<User> savedUsers = createManyUserUseCase.execute(List.of(users));

                int[][] usersIndexesArray = new int[][] {
                                { 0, 1 }, { 0, 2 }, { 0, 4 }, { 0, 5 }, { 0, 7 }, { 0, 9 },
                                { 1, 0 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 8 },
                                { 2, 0 }, { 2, 3 }, { 2, 4 }, { 2, 7 }, { 2, 8 }, { 2, 9 },
                                { 3, 2 }, { 3, 4 }, { 3, 5 }, { 3, 7 }, { 3, 8 },
                                { 4, 1 }, { 4, 2 }, { 4, 3 }, { 4, 6 }, { 4, 9 },
                                { 5, 1 }, { 5, 3 }, { 5, 6 }, { 5, 7 }, { 5, 8 },
                                { 6, 0 }, { 6, 1 }, { 6, 4 }, { 6, 7 }, { 6, 8 },
                                { 7, 0 }, { 7, 3 }, { 7, 6 }, { 7, 9 },
                                { 8, 0 }, { 8, 2 }, { 8, 5 }, { 8, 7 }, { 8, 9 }, { 9, 0 },
                                { 9, 1 }, { 9, 3 }, { 9, 5 }, { 9, 7 },
                };

                List<Follower> followers = new ArrayList<>();
                for (int[] usersIndexes : usersIndexesArray) {
                        FollowerPK pk = new FollowerPK();
                        pk.setFollowerUser(savedUsers.get(usersIndexes[0]));
                        pk.setFollowedUser(savedUsers.get(usersIndexes[1]));
                        Follower follower = new Follower();
                        follower.setId(pk);
                        followers.add(follower);
                }
                createManyFollowerUseCase.execute(followers);
        }

}
