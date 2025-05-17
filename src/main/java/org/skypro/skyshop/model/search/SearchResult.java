package org.skypro.skyshop.model.search;

public class SearchResult {
    final String id;
    final String name;
    final String typeOfContent;


    public SearchResult(String id, String name, String typeOfContent) {
        this.id = id;
        this.name = name;
        this.typeOfContent = typeOfContent;
    }

    public static SearchResult fromSearchable (Searchable searchable) {

        return new SearchResult(searchable.getId().toString(), searchable.getName(), searchable.getTypeOfContent());
    }
}
