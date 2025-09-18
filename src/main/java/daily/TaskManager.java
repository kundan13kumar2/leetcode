package daily;

import java.util.*;

// It throws TLE on leetcode for 3 Test cases
public class TaskManager {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(28);
        list1.add(30);

//        List<Integer> list2 = new ArrayList<>();
//        list2.add(2);
//        list2.add(102);
//        list2.add(20);
//
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(3);
//        list3.add(103);
//        list3.add(15);

        list.add(list1);
//        list.add(list2);
//        list.add(list3);

        TaskManager taskManager = new TaskManager(list);
        taskManager.printDS();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

        taskManager.add(4,15,7);
        taskManager.printDS();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

        taskManager.rmv(15);
        taskManager.printDS();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

//
//        taskManager.edit(4,11);
//        taskManager.printDS();
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");




        System.out.println(taskManager.execTop());
        taskManager.printDS();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(taskManager.execTop());
        taskManager.printDS();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");


//        taskManager.add(5,105,15);
//        taskManager.printDS();
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
//
//        System.out.println(taskManager.execTop());
//        taskManager.printDS();
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    }

    class UserTask {
        private int userId;
        private int taskId;
        private int priority;

        public UserTask(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserTask userTask = (UserTask) o;
            return userTask.taskId == this.taskId && userTask.userId == this.userId && userTask.priority == this.priority;
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, taskId, priority);
        }

        @Override
        public String toString() {
            return this.userId + " " + this.taskId + " " + this.priority;
        }
    }



    Comparator<UserTask> comparator = new Comparator<UserTask>() {
        @Override
        public int compare(UserTask o1, UserTask o2) {
            if (o1.priority != o2.priority) {
                return o2.priority - o1.priority;
            }
            return o2.taskId - o1.taskId;

        }
    };

    PriorityQueue<UserTask> pq = new PriorityQueue<>(comparator);
    Hashtable<Integer, UserTask> taskIdMap = new Hashtable<>();



    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> list : tasks) {
            taskIdMap.put(list.get(1), new UserTask(list.get(0), list.get(1), list.get(2)));
            pq.add(new UserTask(list.get(0), list.get(1), list.get(2)));
        }
    }

    private void printDS() {
        for (UserTask userTask : pq) {
            System.out.println(userTask.toString());
        }
    }

    public void add(int userId, int taskId, int priority) {
        UserTask  userTask = new UserTask(userId, taskId, priority);
        pq.add(userTask);
        taskIdMap.put(taskId, userTask);
    }

    public void edit(int taskId, int newPriority) {
        UserTask userTaskOld = taskIdMap.get(taskId);

        pq.remove(userTaskOld);

        UserTask userTaskNew = new UserTask(userTaskOld.userId,  taskId, newPriority);
        pq.add(userTaskNew);
        taskIdMap.put(taskId, userTaskNew);

    }

    public void rmv(int taskId) {
        UserTask userTask = taskIdMap.get(taskId);
        if(userTask==null){return;}
        System.out.println("Removing " + userTask.toString());
        pq.remove(userTask);
        taskIdMap.remove(taskId);
    }

    public int execTop() {
        UserTask data = pq.poll();
        if (data == null) { return -1;}
        taskIdMap.remove(data.taskId);
        return data.userId;
    }
}
