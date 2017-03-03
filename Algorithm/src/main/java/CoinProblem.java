import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rahul on 2/25/17.
 */
public class CoinProblem {


    private static int makeChange(int amount, int[] coins, int index) {
        if (coins.length == 0)
            throw new IllegalArgumentException("At least one coin required.");

        if (index >= coins.length - 1) return 1;

        int coin = coins[index];
        int ways = 0;
        for (int i = 0; i * coin <= amount; i++) {
            int amountRem = amount - i * coin;
            ways += makeChange(amountRem, coins, index + 1);
        }
        return ways;
    }

    public static int makeChange(int amount) {
        int[] coins = {10, 5, 1};
        return makeChange(amount, coins, 0);
    }

    private static int getChangeCount(int amount, int[] coins) {

        int ways = 0;
        for (int coin : coins) {
            if (amount - coin == 0) {
                ways += 1;
                continue;
            }

            if (amount - coin < 0)
                continue;

            if (amount >= coin) {
                ways = ways + getChangeCount(amount - coin, coins);
            }
        }
        return ways;
    }

    public static int getChangeCount(int amount) {
        int[] coins = {10, 5, 1};
        return getChangeCount(amount, coins);
    }

    public static List<Integer> getMinPossibleCoin(int amount, int[] coins) {
        if (amount < 0)
            return null;

        if (coins.length < 1)
            return null;

        Map<Integer, Integer> coinCounter = new HashMap<>();
        Map<Integer, Integer> coinRef = new HashMap<>();
        for (int i = 1; i <= amount; i++) {
            coinCounter.put(i, Integer.MAX_VALUE);
            coinRef.put(i, -1);
        }

        for (int coin : coins) {
            for (Map.Entry<Integer, Integer> item : coinCounter.entrySet()) {
                if (coin > item.getKey())
                    continue;

                if (coin == item.getKey()) {
                    coinCounter.put(item.getKey(), 1);
                    coinRef.put(item.getKey(), coin);
                    continue;
                }

                if (coin < item.getKey()) {
                    int rem = item.getKey() - coin;
                    int pre = coinCounter.get(rem);
                    if (pre != Integer.MAX_VALUE) {
                        if (pre + 1 < item.getValue()) {
                            coinCounter.put(item.getKey(), pre + 1);
                            coinRef.put(item.getKey(), coin);
                        }
                    }
                }
            }
        }
        List<Integer> res = new LinkedList();
        int coinRefCounter = amount;
        while (coinRefCounter != 0) {
            int coin = coinRef.get(coinRefCounter);
            res.add(coin);
            coinRefCounter = coinRefCounter - coin;
        }
        return res;
    }

    public static void main(String[] args) {
//        int ways = getChangeCount(10);
        int ways = makeChange(15);
        System.out.println("Ways: " + ways);

//        List<Integer> result = getMinPossibleCoin(13, new int[]{7, 4, 3, 6});
//        System.out.println(result.toString());
    }
}
