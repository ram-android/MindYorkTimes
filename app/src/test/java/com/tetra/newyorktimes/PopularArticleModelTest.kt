package com.tetra.newyorktimes

import com.google.gson.Gson
import com.tetra.newyorktimes.popularArticle.model.PopularArticleModel
import com.tetra.newyorktimes.popularArticle.viewModel.helper.PopularArticleJson
import org.junit.After
import org.junit.Before
import org.junit.Test

class PopularArticleModelTest {
    private var model: PopularArticleModel? = null
    private var json: PopularArticleJson? = null

    @Before
    fun setUp() {
        json = Gson().fromJson(PopularArticleTestJson.json, PopularArticleJson::class.java)
        model = PopularArticleModel(json!!)
    }

    @Test
    fun checkTitle() {
        assert(model!!.results == json!!.results)
        assert(model!!.results!!.size != 0)
    }

    @After
    fun tearDown() {
        model = null
    }
}

object PopularArticleTestJson {
    val json = "{\n" +
            "  \"status\": \"OK\",\n" +
            "  \"copyright\": \"Copyright (c) 2020 The New York Times Company.  All Rights Reserved.\",\n" +
            "  \"num_results\": 1514,\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"url\": \"https://www.nytimes.com/2020/01/03/world/middleeast/iranian-general-qassem-soleimani-killed.html\",\n" +
            "      \"adx_keywords\": \"United States International Relations;Suleimani, Qassim;Defense and Military Forces;United States Defense and Military Forces;Baghdad International Airport (Iraq);Islamic Revolutionary Guards Corps;Khamenei, Ali;Trump, Donald J;Baghdad (Iraq);Iran;United States;Deaths (Fatalities)\",\n" +
            "      \"column\": null,\n" +
            "      \"section\": \"World\",\n" +
            "      \"byline\": \"\",\n" +
            "      \"type\": \"Article\",\n" +
            "      \"title\": \"The Killing of Gen. Qassim Suleimani: What We Know Since the U.S. Airstrike\",\n" +
            "      \"abstract\": \"Iran’s supreme leader, Ayatollah Ali Khamenei, promised retaliation. The U.S. moved to send more troops to the Middle East. And a deluge of threats on social media.\",\n" +
            "      \"published_date\": \"2020-01-03\",\n" +
            "      \"source\": \"The New York Times\",\n" +
            "      \"id\": 100000006901970,\n" +
            "      \"asset_id\": 100000006901970,\n" +
            "      \"views\": 1,\n" +
            "      \"des_facet\": [\n" +
            "        \"UNITED STATES INTERNATIONAL RELATIONS\",\n" +
            "        \"DEFENSE AND MILITARY FORCES\",\n" +
            "        \"UNITED STATES DEFENSE AND MILITARY FORCES\",\n" +
            "        \"DEATHS (FATALITIES)\"\n" +
            "      ],\n" +
            "      \"org_facet\": [\n" +
            "        \"BAGHDAD INTERNATIONAL AIRPORT (IRAQ)\",\n" +
            "        \"ISLAMIC REVOLUTIONARY GUARDS CORPS\"\n" +
            "      ],\n" +
            "      \"per_facet\": [\n" +
            "        \"SULEIMANI, QASSIM\",\n" +
            "        \"KHAMENEI, ALI\",\n" +
            "        \"TRUMP, DONALD J\"\n" +
            "      ],\n" +
            "      \"geo_facet\": [\n" +
            "        \"BAGHDAD (IRAQ)\",\n" +
            "        \"IRAN\",\n" +
            "        \"UNITED STATES\"\n" +
            "      ],\n" +
            "      \"media\": [\n" +
            "        {\n" +
            "          \"type\": \"image\",\n" +
            "          \"subtype\": \"photo\",\n" +
            "          \"caption\": \"Iranians mourned the killing of Maj. Gen. Qassim Suleimani in Tehran on Friday.\",\n" +
            "          \"copyright\": \"Ali Mohammadi/Bloomberg News\",\n" +
            "          \"approved_for_syndication\": 1,\n" +
            "          \"media-metadata\": [\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/01/03/world/03iraq-briefing-span/merlin_166605342_bb1d07c1-25be-4a96-8815-857e98b24a47-thumbStandard.jpg\",\n" +
            "              \"format\": \"Standard Thumbnail\",\n" +
            "              \"height\": 75,\n" +
            "              \"width\": 75\n" +
            "            },\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/01/03/world/03iraq-briefing-span/merlin_166605342_bb1d07c1-25be-4a96-8815-857e98b24a47-mediumThreeByTwo210.jpg\",\n" +
            "              \"format\": \"mediumThreeByTwo210\",\n" +
            "              \"height\": 140,\n" +
            "              \"width\": 210\n" +
            "            },\n" +
            "            {\n" +
            "              \"url\": \"https://static01.nyt.com/images/2020/01/03/world/03iraq-briefing-span/merlin_166605342_bb1d07c1-25be-4a96-8815-857e98b24a47-mediumThreeByTwo440.jpg\",\n" +
            "              \"format\": \"mediumThreeByTwo440\",\n" +
            "              \"height\": 293,\n" +
            "              \"width\": 440\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"uri\": \"nyt://article/fbf0a407-5e04-587d-8898-c97705bfeaf9\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"
}