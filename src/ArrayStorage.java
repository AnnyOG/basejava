/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int index = this.size();
        for (int i = 0; i < index; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        int index = this.size();
        storage[index] = r;
    }

    Resume get(String uuid) {
        for (Resume resume: storage) {
            if (resume.uuid.equals(uuid)){
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = this.size();
        for (int i = 0; i < index; i++) {
            if (storage[i].uuid.equals(uuid)){
                storage[i] = storage[index - 1];
                storage[index - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int index = this.size();
        if (index > 0) {
            Resume[] storageWithouNull = new Resume[index];
            for (int i = 0; i < index; i++) {
                storageWithouNull[i] = storage[i];
            }
            return storageWithouNull;
        }
        else {
            return null;
        }
    }

    int size() {
        int index = 0;
        while (storage[index] != null){
            index++;
        }
        return index;
    }
}
