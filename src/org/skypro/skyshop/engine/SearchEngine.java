package org.skypro.skyshop.engine;

import org.skypro.skyshop.Searchable;

public class SearchEngine {
    private final Searchable[] searchList;
    private int count;

    public SearchEngine(int length) {
        this.searchList = new Searchable[length];
        this.count = 0;
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int resultIndex = 0;

        for (int i = 0; i < searchList.length; i++) {
            if (searchList[i] == null) {
                continue;
            }

            String searchTerm = searchList[i].getSearchTerm();

            if (searchTerm.toLowerCase().contains(query.toLowerCase())) {
                result[resultIndex] = searchList[i];
                resultIndex++;

                if (resultIndex >= result.length) {
                    break;
                }
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        if (count < searchList.length) {
            searchList[count] = searchable;
            count++;
        } else {
            System.out.println("Невозможно добавить в поисковой запрос");
        }
    }
}
