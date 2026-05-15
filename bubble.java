import java.io.*;
import java.util.*;

public class bubble {
    public static void main(String[] args) {
        String fileName = "deta"; // 読み込むファイル名

        try {
            // ファイルから数値を読み込んでリストに格納
            List<Integer> numbers = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            reader.close();

            // バブルソートを実行
            bubbleSort(numbers);

            // 結果を表示
            System.out.println("result:");
            for (int num : numbers) {
                System.out.print(num + " ");
            }

        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Numeric conversion error: " + e.getMessage());
        }
    }

    // バブルソートの実装
    public static void bubbleSort(List<Integer> list) {
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // 要素の交換
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }

            // もう交換がなければ終了
            if (!swapped)
                break;
        }
    }
}