/**
 * Array based storage for Resumes
 */

import java.util.Arrays;


public class ArrayStorage {

    private int counter = 0;

    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < counter; i++) {
            storage[i] = null;
        }
        counter = 0;
    }

    void save(Resume r) {
        if (r.uuid != null) {
            storage[counter] = r;
            counter++;
        } else System.out.println("Please input not null Resume");
    }

    Resume get(String uuid) {
        for (int i = 0; i < counter; i++) {
            if ((storage[i].uuid).equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }


    void delete(String uuid) {
        for (int i = 0; i < counter; i++) {
            if ((storage[i].uuid).equals(uuid)) {
                counter--;
                System.arraycopy(storage, i + 1, storage, i, counter - i);
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, counter);
    }

    int size() {

        return counter;
    }
}