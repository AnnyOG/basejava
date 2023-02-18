/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.uuid = "uuid1";
        Resume r2 = new Resume();
        r2.uuid = "uuid2";
        Resume r3 = new Resume();
        r3.uuid = "uuid3";

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        try {
            System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.uuid));
        } catch (NullPointerException e) {
            System.out.println("Uuid not in storage");
        }

        System.out.println("Size: " + ARRAY_STORAGE.size());

        try {
            System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        } catch (NullPointerException e) {
            System.out.println("Uuid not in storage");
        }

        try {
            printAll();
        } catch (NullPointerException e) {
            System.out.println("Storage is empty");
        }

        ARRAY_STORAGE.delete(r1.uuid);

        System.out.println("Size: " + ARRAY_STORAGE.size());

        try {
            printAll();
        } catch (NullPointerException e) {
            System.out.println("Storage is empty");
        }

        ARRAY_STORAGE.clear();
        try {
            printAll();
        } catch (NullPointerException e) {
            System.out.println("Storage is empty");
        }

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        Resume[] all = ARRAY_STORAGE.getAll();
        System.out.println("----------------------------");
        if (all.length == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }

}
