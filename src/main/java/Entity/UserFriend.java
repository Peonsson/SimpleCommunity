//package Entity;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by Peonsson and roppe546.
// *
// * This class describes user relationships (friends) in the database.
// */
//
//@Entity
//@Table(name = "UserFriend")
//public class UserFriend {
//    @Column(name = "UserFriendId")
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int userFriendId;
//
//    // This users friends (other users)
//    @ManyToMany
//    @JoinTable(name = "Friends", joinColumns = @JoinColumn(name = "UserId"), inverseJoinColumns = @JoinColumn(name = "FriendUserId"))
//    private List<User> friends;
//
//    // Other users who have this user as friend
//    @ManyToMany
//    @JoinTable(name = "FriendOf", joinColumns = @JoinColumn(name = "UserId"), inverseJoinColumns = @JoinColumn(name = "FriendUserId"))
//    private List<User> friendOf;
//
//    @Column(name = "Accepted")
//    @NotNull
//    private boolean accepted;
//
//    @Column(name = "Timestamp")
//    @NotNull
//    private Date timestamp;
//
//    public UserFriend() {
//        super();
//    }
//
//    /**
//     * Constructor used to create an object containing friend information of a particular user.
//     *
//     * @param friends
//     * @param friendOf
//     */
//    public UserFriend(List<User> friends, List<User> friendOf) {
//        this.friends = friends;
//        this.friendOf = friendOf;
//        this.accepted = false;
//        this.timestamp = new Date();
//    }
//
//    public int getUserFriendId() {
//        return userFriendId;
//    }
//
//    public List<User> getFriends() {
//        return friends;
//    }
//
//    public void setFriends(List<User> friends) {
//        this.friends = friends;
//    }
//
//    public List<User> getFriendOf() {
//        return friendOf;
//    }
//
//    public void setFriendOf(List<User> friendOf) {
//        this.friendOf = friendOf;
//    }
//
//    public boolean isAccepted() {
//        return accepted;
//    }
//
//    public void setAccepted(boolean accepted) {
//        this.accepted = accepted;
//    }
//
//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public void addFriend(User user, User newFriend) {
//        friends.add(newFriend);
//    }
//
//    public void removeFriend(User friendToRemove) {
//        int indexToRemove = -1;
//
//        for (int i = 0; i < friends.size(); i++) {
//            if (friends.get(i).getUserId() == friendToRemove.getUserId()) {
//                indexToRemove = i;
//                break;
//            }
//        }
//
//        if (indexToRemove != -1) {
//            friends.remove(indexToRemove);
//        }
//    }
//}
