//package com.sample.springelastic.config;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.network.InetAddresses;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
//import java.net.Inet4Address;
//import java.net.InetAddress;
//import java.net.InetSocketAddress;
//import java.net.UnknownHostException;
//
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.sample.springelastic")
//public class ElasticSearchConfig {
//
//    @Value("cluster.name")
//    private String clusterName;
//
//    @Bean
//    public Client elasticSearchClient() {
//        TransportClient transportClient = new PreBuiltTransportClient(getSetting());
//        transportClient.addTransportAddress(new TransportAddress(inetAddress(), 6300));
//        return transportClient;
//    }
//
//    @Bean
//    public ElasticsearchTemplate elasticsearchTemplate() {
//        return new ElasticsearchTemplate(elasticSearchClient());
//    }
//
//    private Settings getSetting() {
//        return Settings.builder()
//                .put("cluster.name", clusterName).build();
//    }
//
//    public InetAddress inetAddress() {
//        try {
//            return Inet4Address.getByName("127.0.0.1");
//        } catch (UnknownHostException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
