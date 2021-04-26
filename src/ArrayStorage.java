import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume resume) {
        for (int r = 0; r < size; r++) {
            if (resume.uuid == storage[r].uuid) {
                System.out.println("Такое резюме уже есть");
                return;
            }
        }
        storage[size] = resume;
        size++;
    }

    Resume get(String uuid) {
        for (int r = 0; r < size; r++) {
            if (storage[r].uuid == uuid) {
                return storage[r];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int deleted = -1;
        for (int r = 0; r < size; r++) {
            if (storage[r].uuid == uuid) {
                deleted = r;
            }
        }
        if (!(deleted == -1)) {
            for (int r = deleted; r < size - 1; r++) {
                storage[r] = storage[r + 1];
            }
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

    void setSize(int size) {
        this.size = size;
    }
}