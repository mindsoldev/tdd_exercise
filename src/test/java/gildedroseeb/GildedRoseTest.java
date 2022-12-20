package gildedroseeb;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        CombinationApprovals.verifyAllCombinations(
        		this::doUpdateQuality, 
        		new String[] {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"}, 
        		new Integer[] {-1, 0, 2, 6, 11},
        		new Integer[] {0, 1, 49, 50});
    }

	private String doUpdateQuality(String name, int sellIn, int quality) {
		Item[] items = new Item[] { new Item(name, sellIn , quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        String itemString = app.items[0].toString();
		return itemString;
	}

}
