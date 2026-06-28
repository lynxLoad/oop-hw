package org.skypro.skyshop.engine;

import org.skypro.skyshop.Searchable;
import org.skypro.skyshop.exception.BestResultNotFound;

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

    private int countMatchesInString(String string, String substring) {
        int count = 0;
        int index = 0;
        int substringIndex = string.indexOf(substring, index);

        while (substringIndex != -1) {
            count++;
            index = substringIndex + substring.length();
            substringIndex = string.indexOf(substring, index);
        }

        return count;
    }

    public Searchable searchMostSuitable(String query) throws BestResultNotFound {
        if (query == null || query.isEmpty()) {
            throw new BestResultNotFound("Не удалось найти товар по запросу: " + query);
        }

        Searchable result = null;
        int maxMatches = -1;

        for (int i = 0; i < searchList.length; i++) {
            if (searchList[i] == null) {
                continue;
            }

            String searchTerm = searchList[i].getSearchTerm();
            int matches = countMatchesInString(searchTerm.toLowerCase(), query.toLowerCase());

            if (matches > maxMatches) {
                maxMatches = matches;
                result = searchList[i];
            }
        }

        if (result == null) {
            throw new BestResultNotFound("Не удалось найти товар по запросу: " + query);
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
