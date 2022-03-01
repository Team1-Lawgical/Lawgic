ALTER TABLE chat
    ADD CONSTRAINT fk_delete_cascade_Chat
        FOREIGN KEY (lawyer_id, client_id, consult_id)
            REFERENCES chat(lawyer_id, client_id, consult_id)
            ON DELETE CASCADE;

ALTER TABLE consult
    ADD CONSTRAINT fk_delete_cascade_consult
        FOREIGN KEY (lawyer_id, client_id)
            REFERENCES chat(lawyer_id, client_id)
            ON DELETE CASCADE;