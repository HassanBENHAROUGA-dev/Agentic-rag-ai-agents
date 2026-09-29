package net.Hassan.transactionservice.agents;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

@AiService
public interface TransactionAiAgent {
    @SystemMessage("You are a helpful assistant. Answer the user question using the provided context")
    Flux<String> chat(String question);
}
