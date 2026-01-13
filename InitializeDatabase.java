import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InitializeDatabase {
    public static void main(String[] args) {
        try {
            // Load HSQLDB driver
            Class.forName("org.hsqldb.jdbcDriver");
            
            // Connect to database
            Connection conn = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost:9001/broadleaf", "sa", "");
            
            // Create table query execution
            Statement stmt = conn.createStatement();
            
            // Drop existing tables and sequences
            dropAllTablesAndSequences(stmt);
            
            System.out.println("Existing tables and sequences have been dropped.");
            
            // Create all tables
            createAllTables(stmt);
            
            // Create all sequences
            createAllSequences(stmt);
            
            // Insert sample data
            insertSampleData(stmt);
            
            // Close connection
            stmt.close();
            conn.close();
            
            System.out.println("Database initialization has been completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void dropAllTablesAndSequences(Statement stmt) throws SQLException {
            // Drop tables
            dropTableIfExists(stmt, "BLC_ADDRESS");
            dropTableIfExists(stmt, "BLC_ADDITIONAL_OFFER_INFO");
            dropTableIfExists(stmt, "BLC_ADMIN_MODULE");
            dropTableIfExists(stmt, "BLC_ADMIN_SECTION");
            dropTableIfExists(stmt, "BLC_ADMIN_PERMISSION");
            dropTableIfExists(stmt, "BLC_ADMIN_SEC_PERM_XREF");
            dropTableIfExists(stmt, "BLC_SYSTEM_PROPERTY");
            dropTableIfExists(stmt, "BLC_ADMIN_PASSWORD_TOKEN");
            dropTableIfExists(stmt, "BLC_ADMIN_ROLE");
            dropTableIfExists(stmt, "BLC_ADMIN_PERMISSION_ENTITY");
            dropTableIfExists(stmt, "BLC_ADMIN_USER");
                    dropTableIfExists(stmt, "BLC_ADMIN_USER_ROLE_XREF");
                    dropTableIfExists(stmt, "BLC_ADMIN_USER_PERMISSION_XREF");
                    dropTableIfExists(stmt, "BLC_STATIC_ASSET_DESC");
            dropTableIfExists(stmt, "BLC_STATIC_ASSET");
            dropTableIfExists(stmt, "BLC_STATIC_ASSET_STRG");
            dropTableIfExists(stmt, "BLC_IMG_STATIC_ASSET");
            dropTableIfExists(stmt, "BLC_URL_HANDLER");
            dropTableIfExists(stmt, "BLC_FLD_ENUM");
            dropTableIfExists(stmt, "BLC_FLD_ENUM_ITEM");
            dropTableIfExists(stmt, "BLC_FLD_GROUP");
            dropTableIfExists(stmt, "BLC_PAGE_TMPLT");
            dropTableIfExists(stmt, "BLC_PAGE_RULE");
            dropTableIfExists(stmt, "BLC_PAGE_ITEM_CRITERIA");
            dropTableIfExists(stmt, "BLC_PAGE");
            dropTableIfExists(stmt, "BLC_FLD_DEF");
            dropTableIfExists(stmt, "BLC_PAGE_FLD");
            dropTableIfExists(stmt, "BLC_SC_FLD");
            dropTableIfExists(stmt, "BLC_SC_FLD_TMPLT");
            dropTableIfExists(stmt, "BLC_SC");
            dropTableIfExists(stmt, "BLC_SC_ITEM_CRITERIA");
            dropTableIfExists(stmt, "BLC_SC_RULE");
            dropTableIfExists(stmt, "BLC_SC_TYPE");
            dropTableIfExists(stmt, "BLC_QUAL_CRIT_SC_XREF");
            dropTableIfExists(stmt, "BLC_CUST_SITE_MAP_GEN_CFG");
            dropTableIfExists(stmt, "BLC_SITE_MAP_CFG");
            dropTableIfExists(stmt, "BLC_SITE");
            dropTableIfExists(stmt, "BLC_SITE_MAP_GEN_CFG");
            dropTableIfExists(stmt, "BLC_SITE_MAP_URL_ENTRY");
            dropTableIfExists(stmt, "BLC_LOCALE");
            dropTableIfExists(stmt, "BLC_EMAIL_TRACKING_CLICKS");
            dropTableIfExists(stmt, "BLC_EMAIL_TRACKING");
            dropTableIfExists(stmt, "BLC_EMAIL_TRACKING_OPENS");
            dropTableIfExists(stmt, "BLC_CURRENCY");
            dropTableIfExists(stmt, "BLC_MODULE_CONFIGURATION");
            dropTableIfExists(stmt, "BLC_RATING_SUMMARY");
            dropTableIfExists(stmt, "BLC_STORE");
            dropTableIfExists(stmt, "BLC_REVIEW_DETAIL");
            dropTableIfExists(stmt, "BLC_ZIP_CODE");
            dropTableIfExists(stmt, "BLC_ORDER_PAYMENT_TRANSACTION");
            dropTableIfExists(stmt, "BLC_REVIEW_FEEDBACK");
            dropTableIfExists(stmt, "BLC_PAYMENT_LOG");
            dropTableIfExists(stmt, "BLC_RATING_DETAIL");
            dropTableIfExists(stmt, "BLC_ORDER_PAYMENT");
            dropTableIfExists(stmt, "BLC_BANK_ACCOUNT_PAYMENT");
            dropTableIfExists(stmt, "BLC_CREDIT_CARD_PAYMENT");
            dropTableIfExists(stmt, "BLC_GIFT_CARD_PAYMENT");
            dropTableIfExists(stmt, "BLC_CAT_SEARCH_FACET_XREF");
            dropTableIfExists(stmt, "BLC_SEARCH_FACET_XREF");
            dropTableIfExists(stmt, "BLC_FIELD");
            dropTableIfExists(stmt, "BLC_CAT_SEARCH_FACET_EXCL_XREF");
            dropTableIfExists(stmt, "BLC_SEARCH_FACET");
            dropTableIfExists(stmt, "BLC_SEARCH_FACET_RANGE");
            dropTableIfExists(stmt, "BLC_SEARCH_INTERCEPT");
            dropTableIfExists(stmt, "BLC_SHIPPING_RATE");
            dropTableIfExists(stmt, "BLC_SEARCH_SYNONYM");
            dropTableIfExists(stmt, "BLC_FULFILLMENT_OPT_BANDED_PRC");
            dropTableIfExists(stmt, "BLC_FULFILLMENT_OPT_BANDED_WGT");
            dropTableIfExists(stmt, "BLC_FULFILLMENT_OPTION_FIXED");
            dropTableIfExists(stmt, "BLC_CODE_TYPES");
            dropTableIfExists(stmt, "BLC_FULFILLMENT_PRICE_BAND");
            dropTableIfExists(stmt, "BLC_FULFILLMENT_WEIGHT_BAND");
            dropTableIfExists(stmt, "BLC_BUND_ITEM_FEE_PRICE");
            dropTableIfExists(stmt, "BLC_BUNDLE_ORDER_ITEM");
            dropTableIfExists(stmt, "BLC_UserConnection");
            dropTableIfExists(stmt, "BLC_DISCRETE_ORDER_ITEM");
            dropTableIfExists(stmt, "BLC_DISC_ITEM_FEE_PRICE");
            dropTableIfExists(stmt, "BLC_DYN_DISCRETE_ORDER_ITEM");
            dropTableIfExists(stmt, "BLC_FULFILLMENT_GROUP_FEE");
            dropTableIfExists(stmt, "BLC_FULFILLMENT_GROUP");
            dropTableIfExists(stmt, "BLC_FULFILLMENT_GROUP_ITEM");
            dropTableIfExists(stmt, "BLC_FULFILLMENT_OPTION");
            dropTableIfExists(stmt, "BLC_GIFTWRAP_ORDER_ITEM");
            dropTableIfExists(stmt, "BLC_ORDER_ITEM");
            dropTableIfExists(stmt, "BLC_CANDIDATE_ITEM_OFFER");
            dropTableIfExists(stmt, "BLC_ITEM_OFFER_QUALIFIER");
            dropTableIfExists(stmt, "BLC_CANDIDATE_ORDER_OFFER");
            dropTableIfExists(stmt, "BLC_ORDER_MULTISHIP_OPTION");
            dropTableIfExists(stmt, "BLC_QUAL_CRIT_OFFER_XREF");
            dropTableIfExists(stmt, "BLC_CUSTOMER_OFFER_XREF");
            dropTableIfExists(stmt, "BLC_ORDER_ITEM_PRICE_DTL");
            dropTableIfExists(stmt, "BLC_PERSONAL_MESSAGE");
            dropTableIfExists(stmt, "BLC_FG_ADJUSTMENT");
            dropTableIfExists(stmt, "BLC_CANDIDATE_FG_OFFER");
            dropTableIfExists(stmt, "BLC_CATEGORY_MEDIA_MAP");
            dropTableIfExists(stmt, "BLC_OFFER_AUDIT");
            dropTableIfExists(stmt, "BLC_ORDER");
            dropTableIfExists(stmt, "BLC_OFFER_CODE");
            dropTableIfExists(stmt, "BLC_OFFER");
            dropTableIfExists(stmt, "BLC_OFFER_INFO");
            dropTableIfExists(stmt, "BLC_CATEGORY_PRODUCT_XREF");
            dropTableIfExists(stmt, "BLC_ORDER_ADJUSTMENT");
            dropTableIfExists(stmt, "BLC_CAT_SITE_MAP_GEN_CFG");
            dropTableIfExists(stmt, "BLC_ORDER_ITEM_ADJUSTMENT");
            dropTableIfExists(stmt, "BLC_CATEGORY_XREF");
            dropTableIfExists(stmt, "BLC_OFFER_RULE");
            dropTableIfExists(stmt, "BLC_ORDER_ITEM_DTL_ADJ");
            dropTableIfExists(stmt, "BLC_SKU_AVAILABILITY");
            dropTableIfExists(stmt, "BLC_OFFER_ITEM_CRITERIA");
            dropTableIfExists(stmt, "BLC_PRODUCT_FEATURED");
            dropTableIfExists(stmt, "BLC_PRODUCT_BUNDLE");
            dropTableIfExists(stmt, "BLC_PRODUCT_OPTION_VALUE");
            dropTableIfExists(stmt, "BLC_PRODUCT_OPTION");
            dropTableIfExists(stmt, "BLC_PRODUCT_OPTION_XREF");
            dropTableIfExists(stmt, "BLC_CHALLENGE_QUESTION");
            dropTableIfExists(stmt, "BLC_SKU_BUNDLE_ITEM");
            dropTableIfExists(stmt, "BLC_COUNTRY");
            dropTableIfExists(stmt, "BLC_CUSTOMER_PASSWORD_TOKEN");
            dropTableIfExists(stmt, "BLC_CUSTOMER");
            dropTableIfExists(stmt, "BLC_SKU");
            dropTableIfExists(stmt, "BLC_CUSTOMER_ROLE");
            dropTableIfExists(stmt, "BLC_ID_GENERATION");
            dropTableIfExists(stmt, "BLC_PHONE");
            dropTableIfExists(stmt, "BLC_ROLE");
            dropTableIfExists(stmt, "BLC_STATE");
            
            // Drop sequences
        dropSequenceIfExists(stmt, "BLC_ADMIN_USER_ADDTL_FIELDS_SEQ");
        dropSequenceIfExists(stmt, "BLC_CUSTOMER_PAYMENT_FIELDS_SEQ");
        dropSequenceIfExists(stmt, "BLC_OFFER_INFO_FIELDS_SEQ");
        dropSequenceIfExists(stmt, "BLC_TRANS_ADDITNL_FIELDS_SEQ");
        dropSequenceIfExists(stmt, "BLC_FIELD_SEARCH_TYPES_SEQ");
        dropSequenceIfExists(stmt, "BLC_ORDER_ITEM_ADD_ATTR_SEQ");
        dropSequenceIfExists(stmt, "BLC_SKU_FULFILLMENT_FLAT_RATES_SEQ");
        dropSequenceIfExists(stmt, "BLC_CATEGORY_IMAGE_SEQ");
        dropSequenceIfExists(stmt, "BLC_ADDRESS_SEQ");
        dropSequenceIfExists(stmt, "BLC_ADDITIONAL_OFFER_INFO_SEQ");
        dropSequenceIfExists(stmt, "BLC_ADMIN_MODULE_SEQ");
        dropSequenceIfExists(stmt, "BLC_ADMIN_SECTION_SEQ");
        dropSequenceIfExists(stmt, "BLC_ADMIN_PERMISSION_SEQ");
        dropSequenceIfExists(stmt, "BLC_SYSTEM_PROPERTY_SEQ");
        dropSequenceIfExists(stmt, "BLC_ADMIN_PASSWORD_TOKEN_SEQ");
        dropSequenceIfExists(stmt, "BLC_ADMIN_ROLE_SEQ");
        dropSequenceIfExists(stmt, "BLC_ADMIN_PERMISSION_ENTITY_SEQ");
        dropSequenceIfExists(stmt, "BLC_ADMIN_USER_SEQ");
        dropSequenceIfExists(stmt, "BLC_STATIC_ASSET_DESC_SEQ");
        dropSequenceIfExists(stmt, "BLC_STATIC_ASSET_SEQ");
        dropSequenceIfExists(stmt, "BLC_STATIC_ASSET_STRG_SEQ");
        dropSequenceIfExists(stmt, "BLC_IMG_STATIC_ASSET_SEQ");
        dropSequenceIfExists(stmt, "BLC_URL_HANDLER_SEQ");
        dropSequenceIfExists(stmt, "BLC_FLD_ENUM_SEQ");
        dropSequenceIfExists(stmt, "BLC_FLD_ENUM_ITEM_SEQ");
        dropSequenceIfExists(stmt, "BLC_FLD_GROUP_SEQ");
        dropSequenceIfExists(stmt, "BLC_PAGE_TMPLT_SEQ");
        dropSequenceIfExists(stmt, "BLC_PAGE_RULE_SEQ");
        dropSequenceIfExists(stmt, "BLC_PAGE_ITEM_CRITERIA_SEQ");
        dropSequenceIfExists(stmt, "BLC_PAGE_SEQ");
        dropSequenceIfExists(stmt, "BLC_FLD_DEF_SEQ");
        dropSequenceIfExists(stmt, "BLC_PAGE_FLD_SEQ");
        dropSequenceIfExists(stmt, "BLC_SC_FLD_SEQ");
        dropSequenceIfExists(stmt, "BLC_SC_FLD_TMPLT_SEQ");
        dropSequenceIfExists(stmt, "BLC_SC_SEQ");
        dropSequenceIfExists(stmt, "BLC_SC_ITEM_CRITERIA_SEQ");
        dropSequenceIfExists(stmt, "BLC_SC_RULE_SEQ");
        dropSequenceIfExists(stmt, "BLC_SC_TYPE_SEQ");
        dropSequenceIfExists(stmt, "BLC_QUAL_CRIT_SC_XREF_SEQ");
        dropSequenceIfExists(stmt, "BLC_CUST_SITE_MAP_GEN_CFG_SEQ");
        dropSequenceIfExists(stmt, "BLC_SITE_MAP_CFG_SEQ");
        dropSequenceIfExists(stmt, "BLC_SITE_SEQ");
        dropSequenceIfExists(stmt, "BLC_SITE_MAP_GEN_CFG_SEQ");
        dropSequenceIfExists(stmt, "BLC_SITE_MAP_URL_ENTRY_SEQ");
        dropSequenceIfExists(stmt, "BLC_LOCALE_SEQ");
        dropSequenceIfExists(stmt, "BLC_EMAIL_TRACKING_CLICKS_SEQ");
        dropSequenceIfExists(stmt, "BLC_EMAIL_TRACKING_SEQ");
        dropSequenceIfExists(stmt, "BLC_EMAIL_TRACKING_OPENS_SEQ");
        dropSequenceIfExists(stmt, "BLC_CURRENCY_SEQ");
        dropSequenceIfExists(stmt, "BLC_MODULE_CONFIGURATION_SEQ");
        dropSequenceIfExists(stmt, "BLC_RATING_SUMMARY_SEQ");
        dropSequenceIfExists(stmt, "BLC_STORE_SEQ");
        dropSequenceIfExists(stmt, "BLC_REVIEW_DETAIL_SEQ");
        dropSequenceIfExists(stmt, "BLC_ZIP_CODE_SEQ");
        dropSequenceIfExists(stmt, "BLC_ORDER_PAYMENT_TRANSACTION_SEQ");
        dropSequenceIfExists(stmt, "BLC_REVIEW_FEEDBACK_SEQ");
        dropSequenceIfExists(stmt, "BLC_PAYMENT_LOG_SEQ");
        dropSequenceIfExists(stmt, "BLC_RATING_DETAIL_SEQ");
        dropSequenceIfExists(stmt, "BLC_ORDER_PAYMENT_SEQ");
        dropSequenceIfExists(stmt, "BLC_BANK_ACCOUNT_PAYMENT_SEQ");
        dropSequenceIfExists(stmt, "BLC_CREDIT_CARD_PAYMENT_SEQ");
        dropSequenceIfExists(stmt, "BLC_GIFT_CARD_PAYMENT_SEQ");
        dropSequenceIfExists(stmt, "BLC_CAT_SEARCH_FACET_XREF_SEQ");
        dropSequenceIfExists(stmt, "BLC_SEARCH_FACET_XREF_SEQ");
        dropSequenceIfExists(stmt, "BLC_FIELD_SEQ");
        dropSequenceIfExists(stmt, "BLC_CAT_SEARCH_FACET_EXCL_XREF_SEQ");
        dropSequenceIfExists(stmt, "BLC_SEARCH_FACET_SEQ");
        dropSequenceIfExists(stmt, "BLC_SEARCH_FACET_RANGE_SEQ");
        dropSequenceIfExists(stmt, "BLC_SEARCH_INTERCEPT_SEQ");
        dropSequenceIfExists(stmt, "BLC_SHIPPING_RATE_SEQ");
        dropSequenceIfExists(stmt, "BLC_SEARCH_SYNONYM_SEQ");
        dropSequenceIfExists(stmt, "BLC_FULFILLMENT_OPT_BANDED_PRC_SEQ");
        dropSequenceIfExists(stmt, "BLC_FULFILLMENT_OPT_BANDED_WGT_SEQ");
        dropSequenceIfExists(stmt, "BLC_FULFILLMENT_OPTION_FIXED_SEQ");
        dropSequenceIfExists(stmt, "BLC_CODE_TYPES_SEQ");
        dropSequenceIfExists(stmt, "BLC_FULFILLMENT_PRICE_BAND_SEQ");
        dropSequenceIfExists(stmt, "BLC_FULFILLMENT_WEIGHT_BAND_SEQ");
        dropSequenceIfExists(stmt, "BLC_BUND_ITEM_FEE_PRICE_SEQ");
        dropSequenceIfExists(stmt, "BLC_BUNDLE_ORDER_ITEM_SEQ");
        dropSequenceIfExists(stmt, "BLC_UserConnection_SEQ");
        dropSequenceIfExists(stmt, "BLC_DISCRETE_ORDER_ITEM_SEQ");
        dropSequenceIfExists(stmt, "BLC_DISC_ITEM_FEE_PRICE_SEQ");
        dropSequenceIfExists(stmt, "BLC_DYN_DISCRETE_ORDER_ITEM_SEQ");
        dropSequenceIfExists(stmt, "BLC_FULFILLMENT_GROUP_FEE_SEQ");
        dropSequenceIfExists(stmt, "BLC_FULFILLMENT_GROUP_SEQ");
        dropSequenceIfExists(stmt, "BLC_FULFILLMENT_GROUP_ITEM_SEQ");
        dropSequenceIfExists(stmt, "BLC_FULFILLMENT_OPTION_SEQ");
        dropSequenceIfExists(stmt, "BLC_GIFTWRAP_ORDER_ITEM_SEQ");
        dropSequenceIfExists(stmt, "BLC_ORDER_ITEM_SEQ");
        dropSequenceIfExists(stmt, "BLC_CANDIDATE_ITEM_OFFER_SEQ");
        dropSequenceIfExists(stmt, "BLC_ITEM_OFFER_QUALIFIER_SEQ");
        dropSequenceIfExists(stmt, "BLC_CANDIDATE_ORDER_OFFER_SEQ");
        dropSequenceIfExists(stmt, "BLC_ORDER_MULTISHIP_OPTION_SEQ");
        dropSequenceIfExists(stmt, "BLC_QUAL_CRIT_OFFER_XREF_SEQ");
        dropSequenceIfExists(stmt, "BLC_CUSTOMER_OFFER_XREF_SEQ");
        dropSequenceIfExists(stmt, "BLC_ORDER_ITEM_PRICE_DTL_SEQ");
        dropSequenceIfExists(stmt, "BLC_PERSONAL_MESSAGE_SEQ");
        dropSequenceIfExists(stmt, "BLC_FG_ADJUSTMENT_SEQ");
        dropSequenceIfExists(stmt, "BLC_CANDIDATE_FG_OFFER_SEQ");
        dropSequenceIfExists(stmt, "BLC_CATEGORY_MEDIA_MAP_SEQ");
        dropSequenceIfExists(stmt, "BLC_OFFER_AUDIT_SEQ");
        dropSequenceIfExists(stmt, "BLC_ORDER_SEQ");
        dropSequenceIfExists(stmt, "BLC_OFFER_CODE_SEQ");
        dropSequenceIfExists(stmt, "BLC_OFFER_SEQ");
        dropSequenceIfExists(stmt, "BLC_OFFER_INFO_SEQ");
        dropSequenceIfExists(stmt, "BLC_CATEGORY_PRODUCT_XREF_SEQ");
        dropSequenceIfExists(stmt, "BLC_ORDER_ADJUSTMENT_SEQ");
        dropSequenceIfExists(stmt, "BLC_CAT_SITE_MAP_GEN_CFG_SEQ");
        dropSequenceIfExists(stmt, "BLC_ORDER_ITEM_ADJUSTMENT_SEQ");
        dropSequenceIfExists(stmt, "BLC_CATEGORY_XREF_SEQ");
        dropSequenceIfExists(stmt, "BLC_OFFER_RULE_SEQ");
        dropSequenceIfExists(stmt, "BLC_ORDER_ITEM_DTL_ADJ_SEQ");
        dropSequenceIfExists(stmt, "BLC_SKU_AVAILABILITY_SEQ");
        dropSequenceIfExists(stmt, "BLC_OFFER_ITEM_CRITERIA_SEQ");
        dropSequenceIfExists(stmt, "BLC_PRODUCT_FEATURED_SEQ");
        dropSequenceIfExists(stmt, "BLC_PRODUCT_BUNDLE_SEQ");
        dropSequenceIfExists(stmt, "BLC_PRODUCT_OPTION_VALUE_SEQ");
        dropSequenceIfExists(stmt, "BLC_PRODUCT_OPTION_SEQ");
        dropSequenceIfExists(stmt, "BLC_PRODUCT_OPTION_XREF_SEQ");
        dropSequenceIfExists(stmt, "BLC_CHALLENGE_QUESTION_SEQ");
        dropSequenceIfExists(stmt, "BLC_SKU_BUNDLE_ITEM_SEQ");
        dropSequenceIfExists(stmt, "BLC_COUNTRY_SEQ");
        dropSequenceIfExists(stmt, "BLC_CUSTOMER_PASSWORD_TOKEN_SEQ");
        dropSequenceIfExists(stmt, "BLC_CUSTOMER_SEQ");
        dropSequenceIfExists(stmt, "BLC_SKU_SEQ");
        dropSequenceIfExists(stmt, "BLC_CUSTOMER_ROLE_SEQ");
        dropSequenceIfExists(stmt, "BLC_ID_GENERATION_SEQ");
        dropSequenceIfExists(stmt, "BLC_PHONE_SEQ");
        dropSequenceIfExists(stmt, "BLC_ROLE_SEQ");
        dropSequenceIfExists(stmt, "BLC_STATE_SEQ");
    }
    
    private static void createAllTables(Statement stmt) throws SQLException {
        // Create BLC_ADDRESS table
        String createAddressTable = "CREATE TABLE BLC_ADDRESS (" +
            "ADDRESS_ID BIGINT NOT NULL, " +
            "FIRST_NAME VARCHAR(255), " +
            "LAST_NAME VARCHAR(255), " +
            "EMAIL_ADDRESS VARCHAR(255), " +
            "COMPANY_NAME VARCHAR(255), " +
            "ADDRESS_LINE1 VARCHAR(255) NOT NULL, " +
            "ADDRESS_LINE2 VARCHAR(255), " +
            "ADDRESS_LINE3 VARCHAR(255), " +
            "CITY VARCHAR(255) NOT NULL, " +
            "STATE_PROV_REGION VARCHAR(255), " +
            "COUNTY VARCHAR(255), " +
            "COUNTRY VARCHAR(255) NOT NULL, " +
            "POSTAL_CODE VARCHAR(255) NOT NULL, " +
            "ZIP_FOUR VARCHAR(255), " +
            "PHONE_PRIMARY_ID BIGINT, " +
            "PHONE_SECONDARY_ID BIGINT, " +
            "PHONE_FAX_ID BIGINT, " +
            "IS_DEFAULT BOOLEAN, " +
            "IS_ACTIVE BOOLEAN, " +
            "IS_BUSINESS BOOLEAN, " +
            "TOKENIZED_ADDRESS VARCHAR(255), " +
            "STANDARDIZED BOOLEAN, " +
            "VERIFICATION_LEVEL VARCHAR(255), " +
            "PRIMARY_PHONE VARCHAR(255), " +
            "SECONDARY_PHONE VARCHAR(255), " +
            "FAX VARCHAR(255), " +
            "PRIMARY KEY (ADDRESS_ID))";
        
        stmt.executeUpdate(createAddressTable);
        System.out.println("BLC_ADDRESS table has been created.");
        
        // Create BLC_ADMIN_SECTION table with USE_DEFAULT_HANDLER column
        String createAdminSectionTable = "CREATE TABLE BLC_ADMIN_SECTION (" +
            "ADMIN_SECTION_ID BIGINT NOT NULL, " +
            "DISPLAY_ORDER INTEGER, " +
            "ADMIN_MODULE_ID BIGINT, " +
            "NAME VARCHAR(255), " +
            "SECTION_KEY VARCHAR(255), " +
            "URL VARCHAR(255), " +
            "CEILING_ENTITY VARCHAR(255), " +
            "DISPLAY_CONTROLLER VARCHAR(255), " +
            "USE_DEFAULT_HANDLER BOOLEAN, " +
            "PRIMARY KEY (ADMIN_SECTION_ID))";
        
        stmt.executeUpdate(createAdminSectionTable);
        System.out.println("BLC_ADMIN_SECTION table has been created.");
        
        // Create BLC_ADDITIONAL_OFFER_INFO table
        String createAdditionalOfferInfoTable = "CREATE TABLE BLC_ADDITIONAL_OFFER_INFO (" +
            "BLC_ORDER_ORDER_ID BIGINT NOT NULL, " +
            "OFFER_ID BIGINT NOT NULL, " +
            "OFFER_INFO_ID BIGINT NOT NULL, " +
            "PRIMARY KEY (BLC_ORDER_ORDER_ID, OFFER_INFO_ID))";
        
        stmt.executeUpdate(createAdditionalOfferInfoTable);
        System.out.println("BLC_ADDITIONAL_OFFER_INFO table has been created.");
        
        // Create BLC_ADMIN_MODULE table
        String createAdminModuleTable = "CREATE TABLE BLC_ADMIN_MODULE (" +
            "ADMIN_MODULE_ID BIGINT NOT NULL, " +
            "NAME VARCHAR(255), " +
            "MODULE_KEY VARCHAR(255), " +
            "ICON VARCHAR(255), " +
            "DISPLAY_ORDER INTEGER, " +
            "PRIMARY KEY (ADMIN_MODULE_ID))";
        
        stmt.executeUpdate(createAdminModuleTable);
        System.out.println("BLC_ADMIN_MODULE table has been created.");
        
        
        // Create BLC_ADMIN_PERMISSION table
        String createAdminPermissionTable = "CREATE TABLE BLC_ADMIN_PERMISSION (" +
            "ADMIN_PERMISSION_ID BIGINT NOT NULL, " +
            "DESCRIPTION VARCHAR(255), " +
            "NAME VARCHAR(255), " +
            "PERMISSION_TYPE VARCHAR(255), " +
            "IS_FRIENDLY BOOLEAN, " +
            "PRIMARY KEY (ADMIN_PERMISSION_ID))";
        
        stmt.executeUpdate(createAdminPermissionTable);
        System.out.println("BLC_ADMIN_PERMISSION table has been created.");
        
        // Create BLC_ADMIN_SEC_PERM_XREF table
        String createAdminSecPermXrefTable = "CREATE TABLE BLC_ADMIN_SEC_PERM_XREF (" +
            "ADMIN_SECTION_ID BIGINT NOT NULL, " +
            "ADMIN_PERMISSION_ID BIGINT NOT NULL, " +
            "PRIMARY KEY (ADMIN_SECTION_ID, ADMIN_PERMISSION_ID))";
        
        stmt.executeUpdate(createAdminSecPermXrefTable);
        System.out.println("BLC_ADMIN_SEC_PERM_XREF table has been created.");
        
        // Create BLC_SYSTEM_PROPERTY table
        String createSystemPropertyTable = "CREATE TABLE BLC_SYSTEM_PROPERTY (" +
            "BLC_SYSTEM_PROPERTY_ID BIGINT NOT NULL, " +
            "FRIENDLY_GROUP VARCHAR(255), " +
            "FRIENDLY_NAME VARCHAR(255), " +
            "FRIENDLY_TAB VARCHAR(255), " +
            "PROPERTY_NAME VARCHAR(255) NOT NULL, " +
            "PROPERTY_TYPE VARCHAR(255), " +
            "PROPERTY_VALUE VARCHAR(255), " +
            "TOOL_TIP VARCHAR(255), " +
            "PRIMARY KEY (BLC_SYSTEM_PROPERTY_ID))";
        
        stmt.executeUpdate(createSystemPropertyTable);
        System.out.println("BLC_SYSTEM_PROPERTY table has been created.");
        
        // Create BLC_ADMIN_PASSWORD_TOKEN table
        String createAdminPasswordTokenTable = "CREATE TABLE BLC_ADMIN_PASSWORD_TOKEN (" +
            "PASSWORD_TOKEN VARCHAR(255) NOT NULL, " +
            "CREATE_DATE TIMESTAMP NOT NULL, " +
            "TOKEN_USED_DATE TIMESTAMP, " +
            "ADMIN_USER_ID BIGINT NOT NULL, " +
            "TOKEN_USED_FLAG BOOLEAN NOT NULL, " +
            "PRIMARY KEY (PASSWORD_TOKEN))";
        
        stmt.executeUpdate(createAdminPasswordTokenTable);
        System.out.println("BLC_ADMIN_PASSWORD_TOKEN table has been created.");
        
        // Create BLC_ADMIN_ROLE table
        String createAdminRoleTable = "CREATE TABLE BLC_ADMIN_ROLE (" +
            "ADMIN_ROLE_ID BIGINT NOT NULL, " +
            "DESCRIPTION VARCHAR(255), " +
            "NAME VARCHAR(255), " +
            "PRIMARY KEY (ADMIN_ROLE_ID))";
        
        stmt.executeUpdate(createAdminRoleTable);
        System.out.println("BLC_ADMIN_ROLE table has been created.");
        
        // Create BLC_ADMIN_PERMISSION_ENTITY table
        String createAdminPermissionEntityTable = "CREATE TABLE BLC_ADMIN_PERMISSION_ENTITY (" +
            "ADMIN_PERMISSION_ENTITY_ID BIGINT NOT NULL, " +
            "CEILING_ENTITY VARCHAR(255), " +
            "ADMIN_PERMISSION_ID BIGINT, " +
            "PRIMARY KEY (ADMIN_PERMISSION_ENTITY_ID))";
        
        stmt.executeUpdate(createAdminPermissionEntityTable);
        System.out.println("BLC_ADMIN_PERMISSION_ENTITY table has been created.");
        
        // Create BLC_ADMIN_ROLE_PERMISSION_XREF table
        String createAdminRolePermissionXrefTable = "CREATE TABLE BLC_ADMIN_ROLE_PERMISSION_XREF (" +
            "ADMIN_ROLE_ID BIGINT NOT NULL, " +
            "ADMIN_PERMISSION_ID BIGINT NOT NULL, " +
            "PRIMARY KEY (ADMIN_ROLE_ID, ADMIN_PERMISSION_ID))";
        
        // Create BLC_ADMIN_PERMISSION_XREF table
        String createAdminPermissionXrefTable = "CREATE TABLE BLC_ADMIN_PERMISSION_XREF (" +
            "ADMIN_PERMISSION_ID BIGINT NOT NULL, " +
            "CHILD_PERMISSION_ID BIGINT NOT NULL, " +
            "PRIMARY KEY (ADMIN_PERMISSION_ID, CHILD_PERMISSION_ID))";
        
        // Create BLC_ADMIN_USER_ROLE_XREF table
        String createAdminUserRoleXrefTable = "CREATE TABLE BLC_ADMIN_USER_ROLE_XREF (" +
            "ADMIN_USER_ID BIGINT NOT NULL, " +
            "ADMIN_ROLE_ID BIGINT NOT NULL, " +
            "PRIMARY KEY (ADMIN_USER_ID, ADMIN_ROLE_ID))";
        
        stmt.executeUpdate(createAdminUserRoleXrefTable);
        System.out.println("BLC_ADMIN_USER_ROLE_XREF table has been created.");
        
        // Create BLC_ADMIN_USER_PERMISSION_XREF table
        String createAdminUserPermissionXrefTable = "CREATE TABLE BLC_ADMIN_USER_PERMISSION_XREF (" +
            "ADMIN_USER_ID BIGINT NOT NULL, " +
            "ADMIN_PERMISSION_ID BIGINT NOT NULL, " +
            "PRIMARY KEY (ADMIN_USER_ID, ADMIN_PERMISSION_ID))";
        
        stmt.executeUpdate(createAdminUserPermissionXrefTable);
        System.out.println("BLC_ADMIN_USER_PERMISSION_XREF table has been created.");
        
        // Create BLC_ADMIN_USER table
        String createAdminUserTable = "CREATE TABLE BLC_ADMIN_USER (" +
            "ADMIN_USER_ID BIGINT NOT NULL, " +
            "ACTIVE_STATUS_FLAG BOOLEAN, " +
            "EMAIL VARCHAR(255), " +
            "LOGIN VARCHAR(255), " +
            "NAME VARCHAR(255), " +
            "PASSWORD VARCHAR(255), " +
            "PHONE_NUMBER VARCHAR(255), " +
            "PRIMARY KEY (ADMIN_USER_ID))";
        
        stmt.executeUpdate(createAdminUserTable);
        System.out.println("BLC_ADMIN_USER table has been created.");
        
        // Create BLC_STATIC_ASSET_DESC table
        String createStaticAssetDescTable = "CREATE TABLE BLC_STATIC_ASSET_DESC (" +
            "STATIC_ASSET_DESC_ID BIGINT NOT NULL, " +
            "DESCRIPTION VARCHAR(255), " +
            "LONG_DESCRIPTION VARCHAR(255), " +
            "PRIMARY KEY (STATIC_ASSET_DESC_ID))";
        
        stmt.executeUpdate(createStaticAssetDescTable);
        System.out.println("BLC_STATIC_ASSET_DESC table has been created.");
        
        // Create BLC_STATIC_ASSET table
        String createStaticAssetTable = "CREATE TABLE BLC_STATIC_ASSET (" +
            "STATIC_ASSET_ID BIGINT NOT NULL, " +
            "ALT_TEXT VARCHAR(255), " +
            "FILE_EXTENSION VARCHAR(255), " +
            "FILE_SIZE BIGINT, " +
            "FULL_URL VARCHAR(255), " +
            "NAME VARCHAR(255), " +
            "STORAGE_TYPE VARCHAR(255), " +
            "TITLE VARCHAR(255), " +
            "PRIMARY KEY (STATIC_ASSET_ID))";
        
        stmt.executeUpdate(createStaticAssetTable);
        System.out.println("BLC_STATIC_ASSET table has been created.");
        
        // Create BLC_STATIC_ASSET_STRG table
        String createStaticAssetStrgTable = "CREATE TABLE BLC_STATIC_ASSET_STRG (" +
            "STATIC_ASSET_STRG_ID BIGINT NOT NULL, " +
            "FILE_DATA BLOB, " +
            "STATIC_ASSET_ID BIGINT, " +
            "PRIMARY KEY (STATIC_ASSET_STRG_ID))";
        
        stmt.executeUpdate(createStaticAssetStrgTable);
        System.out.println("BLC_STATIC_ASSET_STRG table has been created.");
        
        // Create BLC_IMG_STATIC_ASSET table
        String createImgStaticAssetTable = "CREATE TABLE BLC_IMG_STATIC_ASSET (" +
            "STATIC_ASSET_ID BIGINT NOT NULL, " +
            "HEIGHT INT, " +
            "WIDTH INT, " +
            "PRIMARY KEY (STATIC_ASSET_ID))";
        
        stmt.executeUpdate(createImgStaticAssetTable);
        System.out.println("BLC_IMG_STATIC_ASSET table has been created.");
        
        // Create BLC_URL_HANDLER table
        String createUrlHandlerTable = "CREATE TABLE BLC_URL_HANDLER (" +
            "URL_HANDLER_ID BIGINT NOT NULL, " +
            "INCOMING_URL VARCHAR(255), " +
            "NEW_URL VARCHAR(255), " +
            "URL_REDIRECT_TYPE VARCHAR(255), " +
            "PRIMARY KEY (URL_HANDLER_ID))";
        
        stmt.executeUpdate(createUrlHandlerTable);
        System.out.println("BLC_URL_HANDLER table has been created.");
        
        // Create BLC_FLD_ENUM table
        String createFldEnumTable = "CREATE TABLE BLC_FLD_ENUM (" +
            "FLD_ENUM_ID BIGINT NOT NULL, " +
            "NAME VARCHAR(255), " +
            "PRIMARY KEY (FLD_ENUM_ID))";
        
        stmt.executeUpdate(createFldEnumTable);
        System.out.println("BLC_FLD_ENUM table has been created.");
        
        // Create BLC_FLD_ENUM_ITEM table
        String createFldEnumItemTable = "CREATE TABLE BLC_FLD_ENUM_ITEM (" +
            "FLD_ENUM_ITEM_ID BIGINT NOT NULL, " +
            "FLD_ENUM_ID BIGINT, " +
            "NAME VARCHAR(255), " +
            "PRIMARY KEY (FLD_ENUM_ITEM_ID))";
        
        stmt.executeUpdate(createFldEnumItemTable);
        System.out.println("BLC_FLD_ENUM_ITEM table has been created.");
        
        // Create BLC_FLD_GROUP table
        String createFldGroupTable = "CREATE TABLE BLC_FLD_GROUP (" +
            "FLD_GROUP_ID BIGINT NOT NULL, " +
            "INIT_COLLAPSED_FLAG BOOLEAN, " +
            "NAME VARCHAR(255), " +
            "ORDER_VALUE INT, " +
            "PRIMARY KEY (FLD_GROUP_ID))";
        
        stmt.executeUpdate(createFldGroupTable);
        System.out.println("BLC_FLD_GROUP table has been created.");
        
        // Create BLC_PAGE_TMPLT table
        String createPageTmplTable = "CREATE TABLE BLC_PAGE_TMPLT (" +
            "PAGE_TMPLT_ID BIGINT NOT NULL, " +
            "TMPLT_DESCR VARCHAR(255), " +
            "TMPLT_NAME VARCHAR(255), " +
            "TMPLT_PATH VARCHAR(255), " +
            "LOCALE_CODE VARCHAR(255), " +
            "PRIMARY KEY (PAGE_TMPLT_ID))";
        
        stmt.executeUpdate(createPageTmplTable);
        System.out.println("BLC_PAGE_TMPLT table has been created.");
        
        // Create BLC_PAGE_RULE table
        String createPageRuleTable = "CREATE TABLE BLC_PAGE_RULE (" +
            "PAGE_RULE_ID BIGINT NOT NULL, " +
            "MATCH_RULE LONGVARCHAR, " +
            "PRIMARY KEY (PAGE_RULE_ID))";
        
        stmt.executeUpdate(createPageRuleTable);
        System.out.println("BLC_PAGE_RULE table has been created.");
        
        // Create BLC_PAGE_ITEM_CRITERIA table
        String createPageItemCriteriaTable = "CREATE TABLE BLC_PAGE_ITEM_CRITERIA (" +
            "PAGE_ITEM_CRITERIA_ID BIGINT NOT NULL, " +
            "ORDER_ITEM_MATCH_RULE LONGVARCHAR, " +
            "QUANTITY INT, " +
            "PRIMARY KEY (PAGE_ITEM_CRITERIA_ID))";
        
        stmt.executeUpdate(createPageItemCriteriaTable);
        System.out.println("BLC_PAGE_ITEM_CRITERIA table has been created.");
        
        // Create BLC_PAGE table
        String createPageTable = "CREATE TABLE BLC_PAGE (" +
            "PAGE_ID BIGINT NOT NULL, " +
            "ACTIVE_END_DATE TIMESTAMP, " +
            "ACTIVE_START_DATE TIMESTAMP, " +
            "DESCRIPTION VARCHAR(255), " +
            "EXCLUDE_FROM_SITE_MAP BOOLEAN, " +
            "FULL_URL VARCHAR(255), " +
            "META_DESCRIPTION VARCHAR(255), " +
            "META_TITLE VARCHAR(255), " +
            "OFFLINE_FLAG BOOLEAN, " +
            "PRIORITY INT, " +
            "PAGE_TMPLT_ID BIGINT, " +
            "PRIMARY KEY (PAGE_ID))";
        
        stmt.executeUpdate(createPageTable);
        System.out.println("BLC_PAGE table has been created.");
        
        // Create BLC_FLD_DEF table
        String createFldDefTable = "CREATE TABLE BLC_FLD_DEF (" +
            "FLD_DEF_ID BIGINT NOT NULL, " +
            "ALLOW_MULTIPLES BOOLEAN, " +
            "COLUMN_WIDTH VARCHAR(255), " +
            "FLD_TYPE VARCHAR(255), " +
            "FLD_ORDER INT, " +
            "FLD_LABEL VARCHAR(255), " +
            "MAX_LENGTH INT, " +
            "NAME VARCHAR(255), " +
            "REQUIRED_FLAG BOOLEAN, " +
            "TEXT_AREA_FLAG BOOLEAN, " +
            "VALIDATION_ERROR_MSSG_KEY VARCHAR(255), " +
            "VLDTN_REGEX VARCHAR(255), " +
            "FLD_ENUM_ID BIGINT, " +
            "FLD_GROUP_ID BIGINT, " +
            "PRIMARY KEY (FLD_DEF_ID))";
        
        stmt.executeUpdate(createFldDefTable);
        System.out.println("BLC_FLD_DEF table has been created.");
        
        // Create BLC_PAGE_FLD table
        String createPageFldTable = "CREATE TABLE BLC_PAGE_FLD (" +
            "PAGE_FLD_ID BIGINT NOT NULL, " +
            "FLD_KEY VARCHAR(255), " +
            "LOB_VALUE LONGVARCHAR, " +
            "VALUE VARCHAR(255), " +
            "PAGE_ID BIGINT, " +
            "PRIMARY KEY (PAGE_FLD_ID))";
        
        stmt.executeUpdate(createPageFldTable);
        System.out.println("BLC_PAGE_FLD table has been created.");
        
        // Create BLC_SC_FLD table
        String createScFldTable = "CREATE TABLE BLC_SC_FLD (" +
            "SC_FLD_ID BIGINT NOT NULL, " +
            "FLD_KEY VARCHAR(255), " +
            "LOB_VALUE LONGVARCHAR, " +
            "VALUE VARCHAR(255), " +
            "STRUCTURED_CONTENT_ID BIGINT, " +
            "PRIMARY KEY (SC_FLD_ID))";
        
        stmt.executeUpdate(createScFldTable);
        System.out.println("BLC_SC_FLD table has been created.");
        
        // Create BLC_SC_FLD_TMPLT table
        String createScFldTmplTable = "CREATE TABLE BLC_SC_FLD_TMPLT (" +
            "SC_FLD_TMPLT_ID BIGINT NOT NULL, " +
            "NAME VARCHAR(255), " +
            "PRIMARY KEY (SC_FLD_TMPLT_ID))";
        
        stmt.executeUpdate(createScFldTmplTable);
        System.out.println("BLC_SC_FLD_TMPLT table has been created.");
        
        // Create BLC_SC table
        String createScTable = "CREATE TABLE BLC_SC (" +
            "SC_ID BIGINT NOT NULL, " +
            "ACTIVE_END_DATE TIMESTAMP, " +
            "ACTIVE_START_DATE TIMESTAMP, " +
            "DESCRIPTION VARCHAR(255), " +
            "OFFLINE_FLAG BOOLEAN, " +
            "PRIORITY INT, " +
            "LOCALE_CODE VARCHAR(255), " +
            "SC_TYPE_ID BIGINT, " +
            "PRIMARY KEY (SC_ID))";
        
        stmt.executeUpdate(createScTable);
        System.out.println("BLC_SC table has been created.");
        
        // Create BLC_SC_ITEM_CRITERIA table
        String createScItemCriteriaTable = "CREATE TABLE BLC_SC_ITEM_CRITERIA (" +
            "SC_ITEM_CRITERIA_ID BIGINT NOT NULL, " +
            "ORDER_ITEM_MATCH_RULE LONGVARCHAR, " +
            "QUANTITY INT, " +
            "PRIMARY KEY (SC_ITEM_CRITERIA_ID))";
        
        stmt.executeUpdate(createScItemCriteriaTable);
        System.out.println("BLC_SC_ITEM_CRITERIA table has been created.");
        
        // Create BLC_SC_RULE table
        String createScRuleTable = "CREATE TABLE BLC_SC_RULE (" +
            "SC_RULE_ID BIGINT NOT NULL, " +
            "MATCH_RULE LONGVARCHAR, " +
            "PRIMARY KEY (SC_RULE_ID))";
        
        stmt.executeUpdate(createScRuleTable);
        System.out.println("BLC_SC_RULE table has been created.");
        
        // Create BLC_SC_TYPE table
        String createScTypeTable = "CREATE TABLE BLC_SC_TYPE (" +
            "SC_TYPE_ID BIGINT NOT NULL, " +
            "DESCRIPTION VARCHAR(255), " +
            "NAME VARCHAR(255), " +
            "SC_FLD_TMPLT_ID BIGINT, " +
            "PRIMARY KEY (SC_TYPE_ID))";
        
        stmt.executeUpdate(createScTypeTable);
        System.out.println("BLC_SC_TYPE table has been created.");
        
        // Create BLC_QUAL_CRIT_SC_XREF table
        String createQualCritScXrefTable = "CREATE TABLE BLC_QUAL_CRIT_SC_XREF (" +
            "SC_ID BIGINT NOT NULL, " +
            "SC_ITEM_CRITERIA_ID BIGINT NOT NULL, " +
            "PRIMARY KEY (SC_ID, SC_ITEM_CRITERIA_ID))";
        
        stmt.executeUpdate(createQualCritScXrefTable);
        System.out.println("BLC_QUAL_CRIT_SC_XREF table has been created.");
        
        // Create BLC_CUST_SITE_MAP_GEN_CFG table
        String createCustSiteMapGenCfgTable = "CREATE TABLE BLC_CUST_SITE_MAP_GEN_CFG (" +
            "GEN_CONFIG_ID BIGINT NOT NULL, " +
            "PRIMARY KEY (GEN_CONFIG_ID))";
        
        stmt.executeUpdate(createCustSiteMapGenCfgTable);
        System.out.println("BLC_CUST_SITE_MAP_GEN_CFG table has been created.");
        
        // Create BLC_SITE_MAP_CFG table
        String createSiteMapCfgTable = "CREATE TABLE BLC_SITE_MAP_CFG (" +
            "GEN_CONFIG_ID BIGINT NOT NULL, " +
            "CHANGE_FREQ VARCHAR(255), " +
            "DISABLED BOOLEAN, " +
            "GENERATOR_TYPE VARCHAR(255), " +
            "PRIORITY_TYPE VARCHAR(255), " +
            "SITE_MAP_CONFIG_ID BIGINT, " +
            "PRIMARY KEY (GEN_CONFIG_ID))";
        
        stmt.executeUpdate(createSiteMapCfgTable);
        System.out.println("BLC_SITE_MAP_CFG table has been created.");
        
        // Create BLC_SITE table
        String createSiteTable = "CREATE TABLE BLC_SITE (" +
            "SITE_ID BIGINT NOT NULL, " +
            "DEACTIVATED BOOLEAN, " +
            "NAME VARCHAR(255), " +
            "SITE_IDENTIFIER_TYPE VARCHAR(255), " +
            "SITE_IDENTIFIER_VALUE VARCHAR(255), " +
            "PRIMARY KEY (SITE_ID))";
        
        stmt.executeUpdate(createSiteTable);
        System.out.println("BLC_SITE table has been created.");
        
        // Create BLC_SITE_MAP_GEN_CFG table
        String createSiteMapGenCfgTable = "CREATE TABLE BLC_SITE_MAP_GEN_CFG (" +
            "GEN_CONFIG_ID BIGINT NOT NULL, " +
            "INDEXED_LOCATION VARCHAR(255), " +
            "PRIMARY KEY (GEN_CONFIG_ID))";
        
        stmt.executeUpdate(createSiteMapGenCfgTable);
        System.out.println("BLC_SITE_MAP_GEN_CFG table has been created.");
        
        // Create BLC_SITE_MAP_URL_ENTRY table
        String createSiteMapUrlEntryTable = "CREATE TABLE BLC_SITE_MAP_URL_ENTRY (" +
            "URL_ENTRY_ID BIGINT NOT NULL, " +
            "CHANGE_FREQ VARCHAR(255), " +
            "LAST_MODIFIED TIMESTAMP, " +
            "LOCATION VARCHAR(255), " +
            "PRIORITY DECIMAL(19,2), " +
            "SITE_MAP_CFG_ID BIGINT, " +
            "PRIMARY KEY (URL_ENTRY_ID))";
        
        stmt.executeUpdate(createSiteMapUrlEntryTable);
        System.out.println("BLC_SITE_MAP_URL_ENTRY table has been created.");
        
        // Create BLC_LOCALE table
        String createLocaleTable = "CREATE TABLE BLC_LOCALE (" +
            "LOCALE_ID BIGINT NOT NULL, " +
            "DEFAULT_FLAG BOOLEAN, " +
            "FRIENDLY_NAME VARCHAR(255), " +
            "LOCALE_CODE VARCHAR(255), " +
            "USE_IN_SEARCH_INDEX BOOLEAN, " +
            "USE_IN_SITE_MAP BOOLEAN, " +
            "PRIMARY KEY (LOCALE_ID))";
        
        stmt.executeUpdate(createLocaleTable);
        System.out.println("BLC_LOCALE table has been created.");
        
        // Create BLC_EMAIL_TRACKING_CLICKS table
        String createEmailTrackingClicksTable = "CREATE TABLE BLC_EMAIL_TRACKING_CLICKS (" +
            "CLICK_ID BIGINT NOT NULL, " +
            "CUSTOMER_ID BIGINT, " +
            "DATE_CLICKED TIMESTAMP, " +
            "DESTINATION_URI VARCHAR(255), " +
            "QUERY_STRING VARCHAR(255), " +
            "TRACKING_ID BIGINT, " +
            "PRIMARY KEY (CLICK_ID))";
        
        stmt.executeUpdate(createEmailTrackingClicksTable);
        System.out.println("BLC_EMAIL_TRACKING_CLICKS table has been created.");
        
        // Create BLC_EMAIL_TRACKING table
        String createEmailTrackingTable = "CREATE TABLE BLC_EMAIL_TRACKING (" +
            "EMAIL_TRACKING_ID BIGINT NOT NULL, " +
            "DATE_SENT TIMESTAMP, " +
            "EMAIL_ADDRESS VARCHAR(255), " +
            "TYPE VARCHAR(255), " +
            "PRIMARY KEY (EMAIL_TRACKING_ID))";
        
        stmt.executeUpdate(createEmailTrackingTable);
        System.out.println("BLC_EMAIL_TRACKING table has been created.");
        
        // Create BLC_EMAIL_TRACKING_OPENS table
        String createEmailTrackingOpensTable = "CREATE TABLE BLC_EMAIL_TRACKING_OPENS (" +
            "OPEN_ID BIGINT NOT NULL, " +
            "DATE_OPENED TIMESTAMP, " +
            "TRACKING_ID BIGINT, " +
            "USER_AGENT VARCHAR(255), " +
            "PRIMARY KEY (OPEN_ID))";
        
        stmt.executeUpdate(createEmailTrackingOpensTable);
        System.out.println("BLC_EMAIL_TRACKING_OPENS table has been created.");
        
        // Create BLC_CURRENCY table
        String createCurrencyTable = "CREATE TABLE BLC_CURRENCY (" +
            "CURRENCY_ID BIGINT NOT NULL, " +
            "DEFAULT_FLAG BOOLEAN, " +
            "FRIENDLY_NAME VARCHAR(255), " +
            "ISO_CODE VARCHAR(255), " +
            "PRIMARY KEY (CURRENCY_ID))";
        
        stmt.executeUpdate(createCurrencyTable);
        System.out.println("BLC_CURRENCY table has been created.");
        
        // Create BLC_MODULE_CONFIGURATION table
        String createModuleConfigurationTable = "CREATE TABLE BLC_MODULE_CONFIGURATION (" +
            "MODULE_CONFIG_ID BIGINT NOT NULL, " +
            "ACTIVE_END_DATE TIMESTAMP, " +
            "ACTIVE_START_DATE TIMESTAMP, " +
            "CONFIG_TYPE VARCHAR(255), " +
            "IS_DEFAULT BOOLEAN, " +
            "MODULE_NAME VARCHAR(255), " +
            "PRIORITY INT, " +
            "PRIMARY KEY (MODULE_CONFIG_ID))";
        
        stmt.executeUpdate(createModuleConfigurationTable);
        System.out.println("BLC_MODULE_CONFIGURATION table has been created.");
        
        // Create BLC_RATING_SUMMARY table
        String createRatingSummaryTable = "CREATE TABLE BLC_RATING_SUMMARY (" +
            "RATING_SUMMARY_ID BIGINT NOT NULL, " +
            "AVERAGE_RATING DECIMAL(19,2), " +
            "ITEM_ID VARCHAR(255), " +
            "RATING_TYPE VARCHAR(255), " +
            "TOTAL_REVIEWS INT, " +
            "PRIMARY KEY (RATING_SUMMARY_ID))";
        
        stmt.executeUpdate(createRatingSummaryTable);
        System.out.println("BLC_RATING_SUMMARY table has been created.");
        
        // Create BLC_STORE table
        String createStoreTable = "CREATE TABLE BLC_STORE (" +
            "STORE_ID BIGINT NOT NULL, " +
            "ADDRESS_ID BIGINT, " +
            "LATITUDE DECIMAL(19,2), " +
            "LONGITUDE DECIMAL(19,2), " +
            "NAME VARCHAR(255), " +
            "PHONE VARCHAR(255), " +
            "PRIMARY KEY (STORE_ID))";
        
        stmt.executeUpdate(createStoreTable);
        System.out.println("BLC_STORE table has been created.");
        
        // Create BLC_REVIEW_DETAIL table
        String createReviewDetailTable = "CREATE TABLE BLC_REVIEW_DETAIL (" +
            "REVIEW_DETAIL_ID BIGINT NOT NULL, " +
            "HELPFUL_COUNT INT, " +
            "NOT_HELPFUL_COUNT INT, " +
            "PRIMARY KEY (REVIEW_DETAIL_ID))";
        
        stmt.executeUpdate(createReviewDetailTable);
        System.out.println("BLC_REVIEW_DETAIL table has been created.");
        
        // Create BLC_ZIP_CODE table
        String createZipCodeTable = "CREATE TABLE BLC_ZIP_CODE (" +
            "ZIP_CODE_ID BIGINT NOT NULL, " +
            "ZIP_CITY VARCHAR(255), " +
            "ZIP_LATITUDE DECIMAL(19,2), " +
            "ZIP_LONGITUDE DECIMAL(19,2), " +
            "ZIP_STATE VARCHAR(255), " +
            "ZIPCODE VARCHAR(255), " +
            "PRIMARY KEY (ZIP_CODE_ID))";
        
        stmt.executeUpdate(createZipCodeTable);
        System.out.println("BLC_ZIP_CODE table has been created.");
        
        // Create BLC_ORDER_PAYMENT_TRANSACTION table
        String createOrderPaymentTransactionTable = "CREATE TABLE BLC_ORDER_PAYMENT_TRANSACTION (" +
            "PAYMENT_TRANSACTION_ID BIGINT NOT NULL, " +
            "TRANSACTION_AMOUNT DECIMAL(19,5), " +
            "ARCHIVED CHAR(1), " +
            "CUSTOMER_IP_ADDRESS VARCHAR(255), " +
            "DATE_RECORDED TIMESTAMP, " +
            "RAW_RESPONSE LONGVARCHAR, " +
            "SUCCESS BOOLEAN, " +
            "TRANSACTION_TYPE VARCHAR(255), " +
            "ORDER_PAYMENT_ID BIGINT, " +
            "PARENT_TRANSACTION_ID BIGINT, " +
            "PRIMARY KEY (PAYMENT_TRANSACTION_ID))";
        
        stmt.executeUpdate(createOrderPaymentTransactionTable);
        System.out.println("BLC_ORDER_PAYMENT_TRANSACTION table has been created.");
        
        // Create BLC_REVIEW_FEEDBACK table
        String createReviewFeedbackTable = "CREATE TABLE BLC_REVIEW_FEEDBACK (" +
            "REVIEW_FEEDBACK_ID BIGINT NOT NULL, " +
            "IS_HELPFUL BOOLEAN, " +
            "CUSTOMER_ID BIGINT, " +
            "REVIEW_DETAIL_ID BIGINT, " +
            "PRIMARY KEY (REVIEW_FEEDBACK_ID))";
        
        stmt.executeUpdate(createReviewFeedbackTable);
        System.out.println("BLC_REVIEW_FEEDBACK table has been created.");
        
        // Create BLC_PAYMENT_LOG table
        String createPaymentLogTable = "CREATE TABLE BLC_PAYMENT_LOG (" +
            "PAYMENT_LOG_ID BIGINT NOT NULL, " +
            "AMOUNT_PAID DECIMAL(19,5), " +
            "EXCEPTION_MESSAGE VARCHAR(255), " +
            "LOG_TYPE VARCHAR(255), " +
            "ORDER_PAYMENT_ID BIGINT, " +
            "TRANSACTION_SUCCESS BOOLEAN, " +
            "TRANSACTION_TIMESTAMP TIMESTAMP, " +
            "TRANSACTION_TYPE VARCHAR(255), " +
            "USER_NAME VARCHAR(255), " +
            "PRIMARY KEY (PAYMENT_LOG_ID))";
        
        stmt.executeUpdate(createPaymentLogTable);
        System.out.println("BLC_PAYMENT_LOG table has been created.");
        
        // Create BLC_RATING_DETAIL table
        String createRatingDetailTable = "CREATE TABLE BLC_RATING_DETAIL (" +
            "RATING_DETAIL_ID BIGINT NOT NULL, " +
            "RATING DECIMAL(19,2), " +
            "RATING_SUBMITTED_DATE TIMESTAMP, " +
            "CUSTOMER_ID BIGINT, " +
            "RATING_SUMMARY_ID BIGINT, " +
            "PRIMARY KEY (RATING_DETAIL_ID))";
        
        stmt.executeUpdate(createRatingDetailTable);
        System.out.println("BLC_RATING_DETAIL table has been created.");
        
        // Create BLC_ORDER_PAYMENT table
        String createOrderPaymentTable = "CREATE TABLE BLC_ORDER_PAYMENT (" +
            "ORDER_PAYMENT_ID BIGINT NOT NULL, " +
            "AMOUNT DECIMAL(19,5), " +
            "ARCHIVED CHAR(1), " +
            "GATEWAY_TYPE VARCHAR(255), " +
            "REFERENCE_NUMBER VARCHAR(255), " +
            "PAYMENT_TYPE VARCHAR(255), " +
            "ORDER_ID BIGINT, " +
            "PRIMARY KEY (ORDER_PAYMENT_ID))";
        
        stmt.executeUpdate(createOrderPaymentTable);
        System.out.println("BLC_ORDER_PAYMENT table has been created.");
        
        // Create BLC_BANK_ACCOUNT_PAYMENT table
        String createBankAccountPaymentTable = "CREATE TABLE BLC_BANK_ACCOUNT_PAYMENT (" +
            "PAYMENT_ID BIGINT NOT NULL, " +
            "ACCOUNT_NUMBER VARCHAR(255), " +
            "REFERENCE_NUMBER VARCHAR(255), " +
            "ROUTING_NUMBER VARCHAR(255), " +
            "PRIMARY KEY (PAYMENT_ID))";
        
        stmt.executeUpdate(createBankAccountPaymentTable);
        System.out.println("BLC_BANK_ACCOUNT_PAYMENT table has been created.");
        
        // Create BLC_CREDIT_CARD_PAYMENT table
        String createCreditCardPaymentTable = "CREATE TABLE BLC_CREDIT_CARD_PAYMENT (" +
            "PAYMENT_ID BIGINT NOT NULL, " +
            "EXPIRATION_MONTH INT, " +
            "EXPIRATION_YEAR INT, " +
            "NAME_ON_CARD VARCHAR(255), " +
            "PAN VARCHAR(255), " +
            "REFERENCE_NUMBER VARCHAR(255), " +
            "PRIMARY KEY (PAYMENT_ID))";
        
        stmt.executeUpdate(createCreditCardPaymentTable);
        System.out.println("BLC_CREDIT_CARD_PAYMENT table has been created.");
        
        // Create BLC_GIFT_CARD_PAYMENT table
        String createGiftCardPaymentTable = "CREATE TABLE BLC_GIFT_CARD_PAYMENT (" +
            "PAYMENT_ID BIGINT NOT NULL, " +
            "PAN VARCHAR(255), " +
            "PIN VARCHAR(255), " +
            "PRIMARY KEY (PAYMENT_ID))";
        
        stmt.executeUpdate(createGiftCardPaymentTable);
        System.out.println("BLC_GIFT_CARD_PAYMENT table has been created.");
        
        // Create BLC_CAT_SEARCH_FACET_XREF table
        String createCatSearchFacetXrefTable = "CREATE TABLE BLC_CAT_SEARCH_FACET_XREF (" +
            "CATEGORY_SEARCH_FACET_ID BIGINT NOT NULL, " +
            "CATEGORY_ID BIGINT, " +
            "SEARCH_FACET_ID BIGINT, " +
            "SEQUENCE INT, " +
            "PRIMARY KEY (CATEGORY_SEARCH_FACET_ID))";
        
        stmt.executeUpdate(createCatSearchFacetXrefTable);
        System.out.println("BLC_CAT_SEARCH_FACET_XREF table has been created.");
        
        // Create BLC_SEARCH_FACET_XREF table
        String createSearchFacetXrefTable = "CREATE TABLE BLC_SEARCH_FACET_XREF (" +
            "ID BIGINT NOT NULL, " +
            "REQUIRED_FACET_ID BIGINT, " +
            "SEARCH_FACET_ID BIGINT, " +
            "SEQUENCE INT, " +
            "PRIMARY KEY (ID))";
        
        stmt.executeUpdate(createSearchFacetXrefTable);
        System.out.println("BLC_SEARCH_FACET_XREF table has been created.");
        
        // Create BLC_FIELD table
        String createFieldTable = "CREATE TABLE BLC_FIELD (" +
            "FIELD_ID BIGINT NOT NULL, " +
            "ABBREVIATION VARCHAR(255), " +
            "DESCRIPTION VARCHAR(255), " +
            "FACET_FIELD_TYPE VARCHAR(255), " +
            "NAME VARCHAR(255), " +
            "SEARCH_DISPLAY_PRIORITY INT, " +
            "TRANSLATABLE BOOLEAN, " +
            "PRIMARY KEY (FIELD_ID))";
        
        stmt.executeUpdate(createFieldTable);
        System.out.println("BLC_FIELD table has been created.");
        
        // Create BLC_CAT_SEARCH_FACET_EXCL_XREF table
        String createCatSearchFacetExclXrefTable = "CREATE TABLE BLC_CAT_SEARCH_FACET_EXCL_XREF (" +
            "CAT_EXCL_SEARCH_FACET_ID BIGINT NOT NULL, " +
            "CATEGORY_ID BIGINT, " +
            "SEARCH_FACET_ID BIGINT, " +
            "PRIMARY KEY (CAT_EXCL_SEARCH_FACET_ID))";
        
        stmt.executeUpdate(createCatSearchFacetExclXrefTable);
        System.out.println("BLC_CAT_SEARCH_FACET_EXCL_XREF table has been created.");
        
        // Create BLC_SEARCH_FACET table
        String createSearchFacetTable = "CREATE TABLE BLC_SEARCH_FACET (" +
            "SEARCH_FACET_ID BIGINT NOT NULL, " +
            "MULTISELECT BOOLEAN, " +
            "LABEL VARCHAR(255), " +
            "REQUIRES_ALL_DEPENDENT BOOLEAN, " +
            "SEARCH_DISPLAY_PRIORITY INT, " +
            "SHOW_ON_SEARCH BOOLEAN, " +
            "USE_FACET_RANGES BOOLEAN, " +
            "FIELD_ID BIGINT, " +
            "PRIMARY KEY (SEARCH_FACET_ID))";
        
        stmt.executeUpdate(createSearchFacetTable);
        System.out.println("BLC_SEARCH_FACET table has been created.");
        
        // Create BLC_SEARCH_FACET_RANGE table
        String createSearchFacetRangeTable = "CREATE TABLE BLC_SEARCH_FACET_RANGE (" +
            "SEARCH_FACET_RANGE_ID BIGINT NOT NULL, " +
            "MAX_VALUE DECIMAL(19,5), " +
            "MIN_VALUE DECIMAL(19,5), " +
            "SEARCH_FACET_ID BIGINT, " +
            "PRIMARY KEY (SEARCH_FACET_RANGE_ID))";
        
        stmt.executeUpdate(createSearchFacetRangeTable);
        System.out.println("BLC_SEARCH_FACET_RANGE table has been created.");
        
        // Create BLC_SEARCH_INTERCEPT table
        String createSearchInterceptTable = "CREATE TABLE BLC_SEARCH_INTERCEPT (" +
            "SEARCH_REDIRECT_ID BIGINT NOT NULL, " +
            "ACTIVE_END_DATE TIMESTAMP, " +
            "ACTIVE_START_DATE TIMESTAMP, " +
            "PRIORITY INT, " +
            "SEARCH_TERM VARCHAR(255), " +
            "URL VARCHAR(255), " +
            "PRIMARY KEY (SEARCH_REDIRECT_ID))";
        
        stmt.executeUpdate(createSearchInterceptTable);
        System.out.println("BLC_SEARCH_INTERCEPT table has been created.");
        
        // Create BLC_SHIPPING_RATE table
        String createShippingRateTable = "CREATE TABLE BLC_SHIPPING_RATE (" +
            "ID BIGINT NOT NULL, " +
            "BAND_RESULT_PCT INT, " +
            "BAND_UNIT_QTY DECIMAL(19,2), " +
            "FEE_TYPE VARCHAR(255), " +
            "FEE_SUB_TYPE VARCHAR(255), " +
            "PRIMARY KEY (ID))";
        
        stmt.executeUpdate(createShippingRateTable);
        System.out.println("BLC_SHIPPING_RATE table has been created.");
        
        // Create BLC_SEARCH_SYNONYM table
        String createSearchSynonymTable = "CREATE TABLE BLC_SEARCH_SYNONYM (" +
            "SEARCH_SYNONYM_ID BIGINT NOT NULL, " +
            "SYNONYMS VARCHAR(255), " +
            "TERM VARCHAR(255), " +
            "PRIMARY KEY (SEARCH_SYNONYM_ID))";
        
        stmt.executeUpdate(createSearchSynonymTable);
        System.out.println("BLC_SEARCH_SYNONYM table has been created.");
        
        // Create BLC_FULFILLMENT_OPT_BANDED_PRC table
        String createFulfillmentOptBandedPrcTable = "CREATE TABLE BLC_FULFILLMENT_OPT_BANDED_PRC (" +
            "FULFILLMENT_OPTION_ID BIGINT NOT NULL, " +
            "PRICE_BANDING_TYPE VARCHAR(255), " +
            "PRIMARY KEY (FULFILLMENT_OPTION_ID))";
        
        stmt.executeUpdate(createFulfillmentOptBandedPrcTable);
        System.out.println("BLC_FULFILLMENT_OPT_BANDED_PRC table has been created.");
        
        // Create BLC_FULFILLMENT_OPT_BANDED_WGT table
        String createFulfillmentOptBandedWgtTable = "CREATE TABLE BLC_FULFILLMENT_OPT_BANDED_WGT (" +
            "FULFILLMENT_OPTION_ID BIGINT NOT NULL, " +
            "WEIGHT_BANDING_TYPE VARCHAR(255), " +
            "PRIMARY KEY (FULFILLMENT_OPTION_ID))";
        
        stmt.executeUpdate(createFulfillmentOptBandedWgtTable);
        System.out.println("BLC_FULFILLMENT_OPT_BANDED_WGT table has been created.");
        
        // Create BLC_FULFILLMENT_OPTION_FIXED table
        String createFulfillmentOptionFixedTable = "CREATE TABLE BLC_FULFILLMENT_OPTION_FIXED (" +
            "FULFILLMENT_OPTION_ID BIGINT NOT NULL, " +
            "PRICE DECIMAL(19,5), " +
            "PRIMARY KEY (FULFILLMENT_OPTION_ID))";
        
        stmt.executeUpdate(createFulfillmentOptionFixedTable);
        System.out.println("BLC_FULFILLMENT_OPTION_FIXED table has been created.");
        
        // Create BLC_CODE_TYPES table
        String createCodeTypesTable = "CREATE TABLE BLC_CODE_TYPES (" +
            "CODE_ID BIGINT NOT NULL, " +
            "CODE_TYPE VARCHAR(255), " +
            "CODE VARCHAR(255), " +
            "END_DATE TIMESTAMP, " +
            "START_DATE TIMESTAMP, " +
            "PRIMARY KEY (CODE_ID))";
        
        stmt.executeUpdate(createCodeTypesTable);
        System.out.println("BLC_CODE_TYPES table has been created.");
        
        // Create BLC_FULFILLMENT_PRICE_BAND table
        String createFulfillmentPriceBandTable = "CREATE TABLE BLC_FULFILLMENT_PRICE_BAND (" +
            "FULFILLMENT_PRICE_BAND_ID BIGINT NOT NULL, " +
            "RESULT_AMOUNT DECIMAL(19,5), " +
            "RESULT_AMOUNT_TYPE VARCHAR(255), " +
            "RETAIL_PRICE_MINIMUM_AMOUNT DECIMAL(19,5), " +
            "FULFILLMENT_OPTION_ID BIGINT, " +
            "PRIMARY KEY (FULFILLMENT_PRICE_BAND_ID))";
        
        stmt.executeUpdate(createFulfillmentPriceBandTable);
        System.out.println("BLC_FULFILLMENT_PRICE_BAND table has been created.");
        
        // Create BLC_FULFILLMENT_WEIGHT_BAND table
        String createFulfillmentWeightBandTable = "CREATE TABLE BLC_FULFILLMENT_WEIGHT_BAND (" +
            "FULFILLMENT_WEIGHT_BAND_ID BIGINT NOT NULL, " +
            "RESULT_AMOUNT DECIMAL(19,5), " +
            "RESULT_AMOUNT_TYPE VARCHAR(255), " +
            "MINIMUM_WEIGHT DECIMAL(19,2), " +
            "FULFILLMENT_OPTION_ID BIGINT, " +
            "PRIMARY KEY (FULFILLMENT_WEIGHT_BAND_ID))";
        
        stmt.executeUpdate(createFulfillmentWeightBandTable);
        System.out.println("BLC_FULFILLMENT_WEIGHT_BAND table has been created.");
        
        // Create BLC_BUND_ITEM_FEE_PRICE table
        String createBundItemFeePriceTable = "CREATE TABLE BLC_BUND_ITEM_FEE_PRICE (" +
            "BUND_ITEM_FEE_PRICE_ID BIGINT NOT NULL, " +
            "AMOUNT DECIMAL(19,5), " +
            "NAME VARCHAR(255), " +
            "REPORTING_CODE VARCHAR(255), " +
            "BUNDLE_ORDER_ITEM_ID BIGINT, " +
            "PRIMARY KEY (BUND_ITEM_FEE_PRICE_ID))";
        
        stmt.executeUpdate(createBundItemFeePriceTable);
        System.out.println("BLC_BUND_ITEM_FEE_PRICE table has been created.");
        
        // Create BLC_BUNDLE_ORDER_ITEM table
        String createBundleOrderItemTable = "CREATE TABLE BLC_BUNDLE_ORDER_ITEM (" +
            "ORDER_ITEM_ID BIGINT NOT NULL, " +
            "BASE_RETAIL_PRICE DECIMAL(19,5), " +
            "BASE_SALE_PRICE DECIMAL(19,5), " +
            "PRODUCT_BUNDLE_ID BIGINT, " +
            "SKU_ID BIGINT, " +
            "PRIMARY KEY (ORDER_ITEM_ID))";
        
        stmt.executeUpdate(createBundleOrderItemTable);
        System.out.println("BLC_BUNDLE_ORDER_ITEM table has been created.");
        
        // Create BLC_UserConnection table
        String createUserConnectionTable = "CREATE TABLE BLC_UserConnection (" +
            "id BIGINT NOT NULL, " +
            "accessToken VARCHAR(255), " +
            "displayName VARCHAR(255), " +
            "expireTime BIGINT, " +
            "imageUrl VARCHAR(255), " +
            "profileUrl VARCHAR(255), " +
            "providerId VARCHAR(255), " +
            "providerUserId VARCHAR(255), " +
            "refreshToken VARCHAR(255), " +
            "secret VARCHAR(255), " +
            "userId VARCHAR(255), " +
            "PRIMARY KEY (id))";
        
        stmt.executeUpdate(createUserConnectionTable);
        System.out.println("BLC_UserConnection table has been created.");
        
        // Create BLC_DISCRETE_ORDER_ITEM table
        String createDiscreteOrderItemTable = "CREATE TABLE BLC_DISCRETE_ORDER_ITEM (" +
            "ORDER_ITEM_ID BIGINT NOT NULL, " +
            "BASE_RETAIL_PRICE DECIMAL(19,5), " +
            "BASE_SALE_PRICE DECIMAL(19,5), " +
            "ORDER_ITEM_ATTRIBUTE_ID BIGINT, " +
            "PERSONAL_MESSAGE_ID BIGINT, " +
            "PRODUCT_ID BIGINT, " +
            "SKU_ID BIGINT, " +
            "PRIMARY KEY (ORDER_ITEM_ID))";
        
        stmt.executeUpdate(createDiscreteOrderItemTable);
        System.out.println("BLC_DISCRETE_ORDER_ITEM table has been created.");
        
        // Create BLC_DISC_ITEM_FEE_PRICE table
        String createDiscItemFeePriceTable = "CREATE TABLE BLC_DISC_ITEM_FEE_PRICE (" +
            "DISC_ITEM_FEE_PRICE_ID BIGINT NOT NULL, " +
            "AMOUNT DECIMAL(19,5), " +
            "NAME VARCHAR(255), " +
            "REPORTING_CODE VARCHAR(255), " +
            "ORDER_ITEM_ID BIGINT, " +
            "PRIMARY KEY (DISC_ITEM_FEE_PRICE_ID))";
        
        stmt.executeUpdate(createDiscItemFeePriceTable);
        System.out.println("BLC_DISC_ITEM_FEE_PRICE table has been created.");
        
        // Create BLC_DYN_DISCRETE_ORDER_ITEM table
        String createDynDiscreteOrderItemTable = "CREATE TABLE BLC_DYN_DISCRETE_ORDER_ITEM (" +
            "ORDER_ITEM_ID BIGINT NOT NULL, " +
            "PRIMARY KEY (ORDER_ITEM_ID))";
        
        stmt.executeUpdate(createDynDiscreteOrderItemTable);
        System.out.println("BLC_DYN_DISCRETE_ORDER_ITEM table has been created.");
        
        // Create BLC_FULFILLMENT_GROUP_FEE table
        String createFulfillmentGroupFeeTable = "CREATE TABLE BLC_FULFILLMENT_GROUP_FEE (" +
            "FULFILLMENT_GROUP_FEE_ID BIGINT NOT NULL, " +
            "AMOUNT DECIMAL(19,5), " +
            "NAME VARCHAR(255), " +
            "REPORTING_CODE VARCHAR(255), " +
            "FULFILLMENT_GROUP_ID BIGINT, " +
            "PRIMARY KEY (FULFILLMENT_GROUP_FEE_ID))";
        
        stmt.executeUpdate(createFulfillmentGroupFeeTable);
        System.out.println("BLC_FULFILLMENT_GROUP_FEE table has been created.");
        
        // Create BLC_FULFILLMENT_GROUP table
        String createFulfillmentGroupTable = "CREATE TABLE BLC_FULFILLMENT_GROUP (" +
            "FULFILLMENT_GROUP_ID BIGINT NOT NULL, " +
            "DELIVERY_INSTRUCTION VARCHAR(255), " +
            "PRICE DECIMAL(19,5), " +
            "METHOD VARCHAR(255), " +
            "IS_PRIMARY BOOLEAN, " +
            "REFERENCE_NUMBER VARCHAR(255), " +
            "RETAIL_PRICE DECIMAL(19,5), " +
            "SALE_PRICE DECIMAL(19,5), " +
            "ADDRESS_ID BIGINT, " +
            "FULFILLMENT_OPTION_ID BIGINT, " +
            "ORDER_ID BIGINT, " +
            "PRIMARY KEY (FULFILLMENT_GROUP_ID))";
        
        stmt.executeUpdate(createFulfillmentGroupTable);
        System.out.println("BLC_FULFILLMENT_GROUP table has been created.");
        
        // Create BLC_FULFILLMENT_GROUP_ITEM table
        String createFulfillmentGroupItemTable = "CREATE TABLE BLC_FULFILLMENT_GROUP_ITEM (" +
            "FULFILLMENT_GROUP_ITEM_ID BIGINT NOT NULL, " +
            "PRORATED_ORDER_ADJ_VALUE DECIMAL(19,2), " +
            "QUANTITY INT, " +
            "STATUS VARCHAR(255), " +
            "FULFILLMENT_GROUP_ID BIGINT, " +
            "ORDER_ITEM_ID BIGINT, " +
            "PRIMARY KEY (FULFILLMENT_GROUP_ITEM_ID))";
        
        stmt.executeUpdate(createFulfillmentGroupItemTable);
        System.out.println("BLC_FULFILLMENT_GROUP_ITEM table has been created.");
        
        // Create BLC_FULFILLMENT_OPTION table
        String createFulfillmentOptionTable = "CREATE TABLE BLC_FULFILLMENT_OPTION (" +
            "FULFILLMENT_OPTION_ID BIGINT NOT NULL, " +
            "FULFILLMENT_TYPE VARCHAR(255), " +
            "LONG_DESCRIPTION VARCHAR(255), " +
            "NAME VARCHAR(255), " +
            "TAX_CODE VARCHAR(255), " +
            "TAXABLE BOOLEAN, " +
            "USE_FLAT_RATES BOOLEAN, " +
            "PRIMARY KEY (FULFILLMENT_OPTION_ID))";
        
        stmt.executeUpdate(createFulfillmentOptionTable);
        System.out.println("BLC_FULFILLMENT_OPTION table has been created.");
        
        // Create BLC_GIFTWRAP_ORDER_ITEM table
        String createGiftwrapOrderItemTable = "CREATE TABLE BLC_GIFTWRAP_ORDER_ITEM (" +
            "ORDER_ITEM_ID BIGINT NOT NULL, " +
            "PRIMARY KEY (ORDER_ITEM_ID))";
        
        stmt.executeUpdate(createGiftwrapOrderItemTable);
        System.out.println("BLC_GIFTWRAP_ORDER_ITEM table has been created.");
        
        // Create BLC_ORDER_ITEM table
        String createOrderItemTable = "CREATE TABLE BLC_ORDER_ITEM (" +
            "ORDER_ITEM_ID BIGINT NOT NULL, " +
            "NAME VARCHAR(255), " +
            "ORDER_ITEM_TYPE VARCHAR(255), " +
            "PRICE DECIMAL(19,5), " +
            "QUANTITY INT, " +
            "RETAIL_PRICE DECIMAL(19,5), " +
            "RETAIL_PRICE_OVERRIDE BOOLEAN, " +
            "SALE_PRICE DECIMAL(19,5), " +
            "SALE_PRICE_OVERRIDE BOOLEAN, " +
            "CATEGORY_ID BIGINT, " +
            "GIFT_WRAP_ITEM_ID BIGINT, " +
            "ORDER_ID BIGINT, " +
            "PARENT_ORDER_ITEM_ID BIGINT, " +
            "PRIMARY KEY (ORDER_ITEM_ID))";
        
        stmt.executeUpdate(createOrderItemTable);
        System.out.println("BLC_ORDER_ITEM table has been created.");
        
        // Create BLC_CANDIDATE_ITEM_OFFER table
        String createCandidateItemOfferTable = "CREATE TABLE BLC_CANDIDATE_ITEM_OFFER (" +
            "CANDIDATE_ITEM_OFFER_ID BIGINT NOT NULL, " +
            "DISCOUNTED_PRICE DECIMAL(19,5), " +
            "OFFER_ID BIGINT, " +
            "ORDER_ITEM_ID BIGINT, " +
            "PRIMARY KEY (CANDIDATE_ITEM_OFFER_ID))";
        
        stmt.executeUpdate(createCandidateItemOfferTable);
        System.out.println("BLC_CANDIDATE_ITEM_OFFER table has been created.");
        
        // Create BLC_ITEM_OFFER_QUALIFIER table
        String createItemOfferQualifierTable = "CREATE TABLE BLC_ITEM_OFFER_QUALIFIER (" +
            "ITEM_OFFER_QUALIFIER_ID BIGINT NOT NULL, " +
            "QUANTITY BIGINT, " +
            "OFFER_ID BIGINT, " +
            "ORDER_ITEM_ID BIGINT, " +
            "PRIMARY KEY (ITEM_OFFER_QUALIFIER_ID))";
        
        stmt.executeUpdate(createItemOfferQualifierTable);
        System.out.println("BLC_ITEM_OFFER_QUALIFIER table has been created.");
        
        // Create BLC_CANDIDATE_ORDER_OFFER table
        String createCandidateOrderOfferTable = "CREATE TABLE BLC_CANDIDATE_ORDER_OFFER (" +
            "CANDIDATE_ORDER_OFFER_ID BIGINT NOT NULL, " +
            "DISCOUNTED_PRICE DECIMAL(19,5), " +
            "OFFER_ID BIGINT, " +
            "ORDER_ID BIGINT, " +
            "PRIMARY KEY (CANDIDATE_ORDER_OFFER_ID))";
        
        stmt.executeUpdate(createCandidateOrderOfferTable);
        System.out.println("BLC_CANDIDATE_ORDER_OFFER table has been created.");
        
        // Create BLC_ORDER_MULTISHIP_OPTION table
        String createOrderMultishipOptionTable = "CREATE TABLE BLC_ORDER_MULTISHIP_OPTION (" +
            "ORDER_MULTISHIP_OPTION_ID BIGINT NOT NULL, " +
            "ADDRESS_ID BIGINT, " +
            "FULFILLMENT_OPTION_ID BIGINT, " +
            "ORDER_ID BIGINT, " +
            "ORDER_ITEM_ID BIGINT, " +
            "PRIMARY KEY (ORDER_MULTISHIP_OPTION_ID))";
        
        stmt.executeUpdate(createOrderMultishipOptionTable);
        System.out.println("BLC_ORDER_MULTISHIP_OPTION table has been created.");
        
        // Create BLC_QUAL_CRIT_OFFER_XREF table
        String createQualCritOfferXrefTable = "CREATE TABLE BLC_QUAL_CRIT_OFFER_XREF (" +
            "OFFER_ID BIGINT NOT NULL, " +
            "OFFER_ITEM_CRITERIA_ID BIGINT NOT NULL, " +
            "PRIMARY KEY (OFFER_ID, OFFER_ITEM_CRITERIA_ID))";
        
        stmt.executeUpdate(createQualCritOfferXrefTable);
        System.out.println("BLC_QUAL_CRIT_OFFER_XREF table has been created.");
        
        // Create BLC_CUSTOMER_OFFER_XREF table
        String createCustomerOfferXrefTable = "CREATE TABLE BLC_CUSTOMER_OFFER_XREF (" +
            "CUSTOMER_OFFER_ID BIGINT NOT NULL, " +
            "CUSTOMER_ID BIGINT, " +
            "OFFER_ID BIGINT, " +
            "PRIMARY KEY (CUSTOMER_OFFER_ID))";
        
        stmt.executeUpdate(createCustomerOfferXrefTable);
        System.out.println("BLC_CUSTOMER_OFFER_XREF table has been created.");
        
        // Create BLC_ORDER_ITEM_PRICE_DTL table
        String createOrderItemPriceDtlTable = "CREATE TABLE BLC_ORDER_ITEM_PRICE_DTL (" +
            "ORDER_ITEM_PRICE_DTL_ID BIGINT NOT NULL, " +
            "QUANTITY INT, " +
            "USE_SALE_PRICE BOOLEAN, " +
            "ORDER_ITEM_ID BIGINT, " +
            "PRIMARY KEY (ORDER_ITEM_PRICE_DTL_ID))";
        
        stmt.executeUpdate(createOrderItemPriceDtlTable);
        System.out.println("BLC_ORDER_ITEM_PRICE_DTL table has been created.");
        
        // Create BLC_PERSONAL_MESSAGE table
        String createPersonalMessageTable = "CREATE TABLE BLC_PERSONAL_MESSAGE (" +
            "PERSONAL_MESSAGE_ID BIGINT NOT NULL, " +
            "MESSAGE VARCHAR(255), " +
            "MESSAGE_FROM VARCHAR(255), " +
            "MESSAGE_TO VARCHAR(255), " +
            "OCCASION VARCHAR(255), " +
            "PRIMARY KEY (PERSONAL_MESSAGE_ID))";
        
        stmt.executeUpdate(createPersonalMessageTable);
        System.out.println("BLC_PERSONAL_MESSAGE table has been created.");
        
        // Create BLC_FG_ADJUSTMENT table
        String createFgAdjustmentTable = "CREATE TABLE BLC_FG_ADJUSTMENT (" +
            "FG_ADJUSTMENT_ID BIGINT NOT NULL, " +
            "ADJUSTMENT_REASON VARCHAR(255), " +
            "ADJUSTMENT_VALUE DECIMAL(19,5), " +
            "OFFER_ID BIGINT, " +
            "FULFILLMENT_GROUP_ID BIGINT, " +
            "PRIMARY KEY (FG_ADJUSTMENT_ID))";
        
        stmt.executeUpdate(createFgAdjustmentTable);
        System.out.println("BLC_FG_ADJUSTMENT table has been created.");
        
        // Create BLC_CANDIDATE_FG_OFFER table
        String createCandidateFgOfferTable = "CREATE TABLE BLC_CANDIDATE_FG_OFFER (" +
            "CANDIDATE_FG_OFFER_ID BIGINT NOT NULL, " +
            "DISCOUNTED_PRICE DECIMAL(19,5), " +
            "OFFER_ID BIGINT, " +
            "FULFILLMENT_GROUP_ID BIGINT, " +
            "PRIMARY KEY (CANDIDATE_FG_OFFER_ID))";
        
        stmt.executeUpdate(createCandidateFgOfferTable);
        System.out.println("BLC_CANDIDATE_FG_OFFER table has been created.");
        
        // Create BLC_CATEGORY_MEDIA_MAP table
        String createCategoryMediaMapTable = "CREATE TABLE BLC_CATEGORY_MEDIA_MAP (" +
            "CATEGORY_MEDIA_MAP_ID BIGINT NOT NULL, " +
            "MAP_KEY VARCHAR(255), " +
            "BLC_CATEGORY_CATEGORY_ID BIGINT, " +
            "MEDIA_ID BIGINT, " +
            "PRIMARY KEY (CATEGORY_MEDIA_MAP_ID))";
        
        stmt.executeUpdate(createCategoryMediaMapTable);
        System.out.println("BLC_CATEGORY_MEDIA_MAP table has been created.");
        
        // Create BLC_OFFER_AUDIT table
        String createOfferAuditTable = "CREATE TABLE BLC_OFFER_AUDIT (" +
            "OFFER_AUDIT_ID BIGINT NOT NULL, " +
            "CUSTOMER_ID BIGINT, " +
            "OFFER_CODE_ID BIGINT, " +
            "OFFER_ID BIGINT, " +
            "ORDER_ID BIGINT, " +
            "REDEEMED_DATE TIMESTAMP, " +
            "PRIMARY KEY (OFFER_AUDIT_ID))";
        
        stmt.executeUpdate(createOfferAuditTable);
        System.out.println("BLC_OFFER_AUDIT table has been created.");
        
        // Create BLC_ORDER table
        String createOrderTable = "CREATE TABLE BLC_ORDER (" +
            "ORDER_ID BIGINT NOT NULL, " +
            "CREATED_BY BIGINT, " +
            "DATE_CREATED TIMESTAMP, " +
            "DATE_UPDATED TIMESTAMP, " +
            "UPDATED_BY BIGINT, " +
            "EMAIL_ADDRESS VARCHAR(255), " +
            "NAME VARCHAR(255), " +
            "ORDER_NUMBER VARCHAR(255), " +
            "ORDER_STATUS VARCHAR(255), " +
            "ORDER_SUBTOTAL DECIMAL(19,5), " +
            "SUBMIT_DATE TIMESTAMP, " +
            "TAX_OVERRIDE BOOLEAN, " +
            "ORDER_TOTAL DECIMAL(19,5), " +
            "CURRENCY_CODE VARCHAR(255), " +
            "CUSTOMER_ID BIGINT, " +
            "LOCALE_CODE VARCHAR(255), " +
            "PRIMARY KEY (ORDER_ID))";
        
        stmt.executeUpdate(createOrderTable);
        System.out.println("BLC_ORDER table has been created.");
        
        // Create BLC_OFFER_CODE table
        String createOfferCodeTable = "CREATE TABLE BLC_OFFER_CODE (" +
            "OFFER_CODE_ID BIGINT NOT NULL, " +
            "END_DATE TIMESTAMP, " +
            "MAX_USES INT, " +
            "OFFER_CODE VARCHAR(255), " +
            "START_DATE TIMESTAMP, " +
            "USES INT, " +
            "OFFER_ID BIGINT, " +
            "PRIMARY KEY (OFFER_CODE_ID))";
        
        stmt.executeUpdate(createOfferCodeTable);
        System.out.println("BLC_OFFER_CODE table has been created.");
        
        // Create BLC_OFFER table
        String createOfferTable = "CREATE TABLE BLC_OFFER (" +
            "OFFER_ID BIGINT NOT NULL, " +
            "APPLY_TO_SALE_PRICE BOOLEAN, " +
            "APPLY_TO_CHILD_ITEMS BOOLEAN, " +
            "AUTOMATICALLY_ADDED BOOLEAN, " +
            "COMBINABLE_WITH_OTHER_OFFERS BOOLEAN, " +
            "OFFER_DELIVERY_TYPE VARCHAR(255), " +
            "OFFER_DESCRIPTION VARCHAR(255), " +
            "OFFER_DISCOUNT_TYPE VARCHAR(255), " +
            "END_DATE TIMESTAMP, " +
            "MARKETING_MESSASGE VARCHAR(255), " +
            "MAX_USES_PER_CUSTOMER INT, " +
            "OFFER_NAME VARCHAR(255), " +
            "OFFER_ITEM_QUALIFIER_RULE VARCHAR(255), " +
            "OFFER_ITEM_TARGET_RULE VARCHAR(255), " +
            "ORDER_MIN_TOTAL DECIMAL(19,5), " +
            "PRIORITIZE_MORE_LIMITED_OFFERS BOOLEAN, " +
            "REQUIRES_RELATED_TAR_QUAL BOOLEAN, " +
            "STACKABLE BOOLEAN, " +
            "START_DATE TIMESTAMP, " +
            "TARGET_SYSTEM VARCHAR(255), " +
            "TOTALITARIAN_OFFER BOOLEAN, " +
            "USE_NEW_FORMAT BOOLEAN, " +
            "OFFER_TYPE VARCHAR(255), " +
            "USES INT, " +
            "VALUE DECIMAL(19,5), " +
            "PRIMARY KEY (OFFER_ID))";
        
        stmt.executeUpdate(createOfferTable);
        System.out.println("BLC_OFFER table has been created.");
        
        // Create BLC_OFFER_INFO table
        String createOfferInfoTable = "CREATE TABLE BLC_OFFER_INFO (" +
            "OFFER_INFO_ID BIGINT NOT NULL, " +
            "FIELD_NAME VARCHAR(255), " +
            "FIELD_VALUE VARCHAR(255), " +
            "OFFER_ID BIGINT, " +
            "PRIMARY KEY (OFFER_INFO_ID))";
        
        stmt.executeUpdate(createOfferInfoTable);
        System.out.println("BLC_OFFER_INFO table has been created.");
        
        // Create BLC_CATEGORY_PRODUCT_XREF table
        String createCategoryProductXrefTable = "CREATE TABLE BLC_CATEGORY_PRODUCT_XREF (" +
            "CATEGORY_PRODUCT_ID BIGINT NOT NULL, " +
            "DISPLAY_ORDER INT, " +
            "CATEGORY_ID BIGINT, " +
            "PRODUCT_ID BIGINT, " +
            "PRIMARY KEY (CATEGORY_PRODUCT_ID))";
        
        stmt.executeUpdate(createCategoryProductXrefTable);
        System.out.println("BLC_CATEGORY_PRODUCT_XREF table has been created.");
        
        // Create BLC_ORDER_ADJUSTMENT table
        String createOrderAdjustmentTable = "CREATE TABLE BLC_ORDER_ADJUSTMENT (" +
            "ORDER_ADJUSTMENT_ID BIGINT NOT NULL, " +
            "ADJUSTMENT_REASON VARCHAR(255), " +
            "ADJUSTMENT_VALUE DECIMAL(19,5), " +
            "OFFER_ID BIGINT, " +
            "ORDER_ID BIGINT, " +
            "PRIMARY KEY (ORDER_ADJUSTMENT_ID))";
        
        stmt.executeUpdate(createOrderAdjustmentTable);
        System.out.println("BLC_ORDER_ADJUSTMENT table has been created.");
        
        // Create BLC_CAT_SITE_MAP_GEN_CFG table
        String createCatSiteMapGenCfgTable = "CREATE TABLE BLC_CAT_SITE_MAP_GEN_CFG (" +
            "GEN_CONFIG_ID BIGINT NOT NULL, " +
            "ROOT_CATEGORY_ID BIGINT, " +
            "PRIMARY KEY (GEN_CONFIG_ID))";
        
        stmt.executeUpdate(createCatSiteMapGenCfgTable);
        System.out.println("BLC_CAT_SITE_MAP_GEN_CFG table has been created.");
        
        // Create BLC_ORDER_ITEM_ADJUSTMENT table
        String createOrderItemAdjustmentTable = "CREATE TABLE BLC_ORDER_ITEM_ADJUSTMENT (" +
            "ORDER_ITEM_ADJUSTMENT_ID BIGINT NOT NULL, " +
            "ADJUSTMENT_REASON VARCHAR(255), " +
            "ADJUSTMENT_VALUE DECIMAL(19,5), " +
            "OFFER_ID BIGINT, " +
            "ORDER_ITEM_ID BIGINT, " +
            "PRIMARY KEY (ORDER_ITEM_ADJUSTMENT_ID))";
        
        stmt.executeUpdate(createOrderItemAdjustmentTable);
        System.out.println("BLC_ORDER_ITEM_ADJUSTMENT table has been created.");
        
        // Create BLC_CATEGORY_XREF table
        String createCategoryXrefTable = "CREATE TABLE BLC_CATEGORY_XREF (" +
            "CATEGORY_XREF_ID BIGINT NOT NULL, " +
            "DISPLAY_ORDER INT, " +
            "CATEGORY_ID BIGINT, " +
            "SUB_CATEGORY_ID BIGINT, " +
            "PRIMARY KEY (CATEGORY_XREF_ID))";
        
        stmt.executeUpdate(createCategoryXrefTable);
        System.out.println("BLC_CATEGORY_XREF table has been created.");
        
        // Create BLC_OFFER_RULE table
        String createOfferRuleTable = "CREATE TABLE BLC_OFFER_RULE (" +
            "OFFER_RULE_ID BIGINT NOT NULL, " +
            "MATCH_RULE LONGVARCHAR, " +
            "PRIMARY KEY (OFFER_RULE_ID))";
        
        stmt.executeUpdate(createOfferRuleTable);
        System.out.println("BLC_OFFER_RULE table has been created.");
        
        // Create BLC_ORDER_ITEM_DTL_ADJ table
        String createOrderItemDtlAdjTable = "CREATE TABLE BLC_ORDER_ITEM_DTL_ADJ (" +
            "ORDER_ITEM_DTL_ADJ_ID BIGINT NOT NULL, " +
            "APPLIED_TO_SALE_PRICE BOOLEAN, " +
            "ADJUSTMENT_REASON VARCHAR(255), " +
            "ADJUSTMENT_VALUE DECIMAL(19,5), " +
            "OFFER_ID BIGINT, " +
            "ORDER_ITEM_PRICE_DTL_ID BIGINT, " +
            "PRIMARY KEY (ORDER_ITEM_DTL_ADJ_ID))";
        
        stmt.executeUpdate(createOrderItemDtlAdjTable);
        System.out.println("BLC_ORDER_ITEM_DTL_ADJ table has been created.");
        
        // Create BLC_SKU_AVAILABILITY table
        String createSkuAvailabilityTable = "CREATE TABLE BLC_SKU_AVAILABILITY (" +
            "SKU_AVAILABILITY_ID BIGINT NOT NULL, " +
            "AVAILABILITY_DATE TIMESTAMP, " +
            "AVAILABILITY_STATUS VARCHAR(255), " +
            "LOCATION_ID BIGINT, " +
            "QTY_ON_HAND INT, " +
            "RESERVE_QTY INT, " +
            "SKU_ID BIGINT, " +
            "PRIMARY KEY (SKU_AVAILABILITY_ID))";
        
        stmt.executeUpdate(createSkuAvailabilityTable);
        System.out.println("BLC_SKU_AVAILABILITY table has been created.");
        
        // Create BLC_OFFER_ITEM_CRITERIA table
        String createOfferItemCriteriaTable = "CREATE TABLE BLC_OFFER_ITEM_CRITERIA (" +
            "OFFER_ITEM_CRITERIA_ID BIGINT NOT NULL, " +
            "ORDER_ITEM_MATCH_RULE LONGVARCHAR, " +
            "QUANTITY INT, " +
            "PRIMARY KEY (OFFER_ITEM_CRITERIA_ID))";
        
        stmt.executeUpdate(createOfferItemCriteriaTable);
        System.out.println("BLC_OFFER_ITEM_CRITERIA table has been created.");
        
        // Create BLC_PRODUCT_FEATURED table
        String createProductFeaturedTable = "CREATE TABLE BLC_PRODUCT_FEATURED (" +
            "FEATURED_PRODUCT_ID BIGINT NOT NULL, " +
            "DISPLAY_ORDER INT, " +
            "CATEGORY_ID BIGINT, " +
            "PRODUCT_ID BIGINT, " +
            "PRIMARY KEY (FEATURED_PRODUCT_ID))";
        
        stmt.executeUpdate(createProductFeaturedTable);
        System.out.println("BLC_PRODUCT_FEATURED table has been created.");
        
        // Create BLC_PRODUCT_BUNDLE table
        String createProductBundleTable = "CREATE TABLE BLC_PRODUCT_BUNDLE (" +
            "PRODUCT_ID BIGINT NOT NULL, " +
            "AUTO_BUNDLE BOOLEAN, " +
            "BUNDLE_PROMOTABLE BOOLEAN, " +
            "ITEMS_PROMOTABLE BOOLEAN, " +
            "PRICING_MODEL VARCHAR(255), " +
            "PRIMARY KEY (PRODUCT_ID))";
        
        stmt.executeUpdate(createProductBundleTable);
        System.out.println("BLC_PRODUCT_BUNDLE table has been created.");
        
        // Create BLC_PRODUCT_OPTION_VALUE table
        String createProductOptionValueTable = "CREATE TABLE BLC_PRODUCT_OPTION_VALUE (" +
            "PRODUCT_OPTION_VALUE_ID BIGINT NOT NULL, " +
            "ATTRIBUTE_VALUE VARCHAR(255), " +
            "DISPLAY_ORDER INT, " +
            "PRICE_ADJUSTMENT DECIMAL(19,5), " +
            "PRODUCT_OPTION_ID BIGINT, " +
            "PRIMARY KEY (PRODUCT_OPTION_VALUE_ID))";
        
        stmt.executeUpdate(createProductOptionValueTable);
        System.out.println("BLC_PRODUCT_OPTION_VALUE table has been created.");
        
        // Create BLC_PRODUCT_OPTION table
        String createProductOptionTable = "CREATE TABLE BLC_PRODUCT_OPTION (" +
            "PRODUCT_OPTION_ID BIGINT NOT NULL, " +
            "ATTRIBUTE_NAME VARCHAR(255), " +
            "DISPLAY_ORDER INT, " +
            "ERROR_CODE VARCHAR(255), " +
            "ERROR_MESSAGE VARCHAR(255), " +
            "LABEL VARCHAR(255), " +
            "NAME VARCHAR(255), " +
            "REQUIRED BOOLEAN, " +
            "TYPE VARCHAR(255), " +
            "USE_IN_SKU_GENERATION BOOLEAN, " +
            "VALIDATION_STRATEGY_TYPE VARCHAR(255), " +
            "VALIDATION_TYPE VARCHAR(255), " +
            "PRIMARY KEY (PRODUCT_OPTION_ID))";
        
        stmt.executeUpdate(createProductOptionTable);
        System.out.println("BLC_PRODUCT_OPTION table has been created.");
        
        // Create BLC_PRODUCT_OPTION_XREF table
        String createProductOptionXrefTable = "CREATE TABLE BLC_PRODUCT_OPTION_XREF (" +
            "PRODUCT_OPTION_XREF_ID BIGINT NOT NULL, " +
            "PRODUCT_ID BIGINT, " +
            "PRODUCT_OPTION_ID BIGINT, " +
            "PRIMARY KEY (PRODUCT_OPTION_XREF_ID))";
        
        stmt.executeUpdate(createProductOptionXrefTable);
        System.out.println("BLC_PRODUCT_OPTION_XREF table has been created.");
        
        // Create BLC_CHALLENGE_QUESTION table
        String createChallengeQuestionTable = "CREATE TABLE BLC_CHALLENGE_QUESTION (" +
            "QUESTION_ID BIGINT NOT NULL, " +
            "QUESTION VARCHAR(255), " +
            "PRIMARY KEY (QUESTION_ID))";
        
        stmt.executeUpdate(createChallengeQuestionTable);
        System.out.println("BLC_CHALLENGE_QUESTION table has been created.");
        
        // Create BLC_SKU_BUNDLE_ITEM table
        String createSkuBundleItemTable = "CREATE TABLE BLC_SKU_BUNDLE_ITEM (" +
            "SKU_BUNDLE_ITEM_ID BIGINT NOT NULL, " +
            "ITEM_SALE_PRICE DECIMAL(19,5), " +
            "QUANTITY INT, " +
            "PRODUCT_BUNDLE_ID BIGINT, " +
            "SKU_ID BIGINT, " +
            "PRIMARY KEY (SKU_BUNDLE_ITEM_ID))";
        
        stmt.executeUpdate(createSkuBundleItemTable);
        System.out.println("BLC_SKU_BUNDLE_ITEM table has been created.");
        
        // Create BLC_COUNTRY table
        String createCountryTable = "CREATE TABLE BLC_COUNTRY (" +
            "ABBREVIATION VARCHAR(255) NOT NULL, " +
            "NAME VARCHAR(255), " +
            "PRIMARY KEY (ABBREVIATION))";
        
        stmt.executeUpdate(createCountryTable);
        System.out.println("BLC_COUNTRY table has been created.");
        
        // Create BLC_CUSTOMER_PASSWORD_TOKEN table
        String createCustomerPasswordTokenTable = "CREATE TABLE BLC_CUSTOMER_PASSWORD_TOKEN (" +
            "PASSWORD_TOKEN VARCHAR(255) NOT NULL, " +
            "CREATE_DATE TIMESTAMP NOT NULL, " +
            "TOKEN_USED_DATE TIMESTAMP, " +
            "CUSTOMER_ID BIGINT NOT NULL, " +
            "TOKEN_USED_FLAG BOOLEAN NOT NULL, " +
            "PRIMARY KEY (PASSWORD_TOKEN))";
        
        stmt.executeUpdate(createCustomerPasswordTokenTable);
        System.out.println("BLC_CUSTOMER_PASSWORD_TOKEN table has been created.");
        
        // Create BLC_CUSTOMER table
        String createCustomerTable = "CREATE TABLE BLC_CUSTOMER (" +
            "CUSTOMER_ID BIGINT NOT NULL, " +
            "CREATED_BY BIGINT, " +
            "DATE_CREATED TIMESTAMP, " +
            "DATE_UPDATED TIMESTAMP, " +
            "UPDATED_BY BIGINT, " +
            "CHALLENGE_ANSWER VARCHAR(255), " +
            "DEACTIVATED BOOLEAN, " +
            "EMAIL_ADDRESS VARCHAR(255), " +
            "FIRST_NAME VARCHAR(255), " +
            "LAST_NAME VARCHAR(255), " +
            "PASSWORD VARCHAR(255), " +
            "PASSWORD_CHANGE_REQUIRED BOOLEAN, " +
            "RECEIVE_EMAIL BOOLEAN, " +
            "IS_REGISTERED BOOLEAN, " +
            "TAX_EXEMPT BOOLEAN, " +
            "USERNAME VARCHAR(255), " +
            "CHALLENGE_QUESTION_ID BIGINT, " +
            "LOCALE_CODE VARCHAR(255), " +
            "PRIMARY KEY (CUSTOMER_ID))";
        
        stmt.executeUpdate(createCustomerTable);
        System.out.println("BLC_CUSTOMER table has been created.");
        
        // Create BLC_SKU table
        String createSkuTable = "CREATE TABLE BLC_SKU (" +
            "SKU_ID BIGINT NOT NULL, " +
            "ACTIVE_END_DATE TIMESTAMP, " +
            "ACTIVE_START_DATE TIMESTAMP, " +
            "AVAILABLE_FLAG BOOLEAN, " +
            "COST DECIMAL(19,5), " +
            "DESCRIPTION VARCHAR(255), " +
            "CONTAINER_SHAPE VARCHAR(255), " +
            "DEPTH DECIMAL(19,2), " +
            "DIMENSION_UNIT_OF_MEASURE VARCHAR(255), " +
            "GIRTH DECIMAL(19,2), " +
            "HEIGHT DECIMAL(19,2), " +
            "CONTAINER_SIZE VARCHAR(255), " +
            "WIDTH DECIMAL(19,2), " +
            "EXTERNAL_ID VARCHAR(255), " +
            "FULFILLMENT_TYPE VARCHAR(255), " +
            "INVENTORY_TYPE VARCHAR(255), " +
            "IS_MACHINE_SORTABLE BOOLEAN, " +
            "LONG_DESCRIPTION VARCHAR(255), " +
            "NAME VARCHAR(255), " +
            "QUANTITY_AVAILABLE INT, " +
            "RETAIL_PRICE DECIMAL(19,5), " +
            "SALE_PRICE DECIMAL(19,5), " +
            "TAX_CODE VARCHAR(255), " +
            "TAXABLE_FLAG BOOLEAN, " +
            "UPC VARCHAR(255), " +
            "WEIGHT DECIMAL(19,2), " +
            "WEIGHT_UNIT_OF_MEASURE VARCHAR(255), " +
            "DEFAULT_PRODUCT_ID BIGINT, " +
            "PRIMARY KEY (SKU_ID))";
        
        stmt.executeUpdate(createSkuTable);
        System.out.println("BLC_SKU table has been created.");
        
        // Create BLC_CUSTOMER_ROLE table
        String createCustomerRoleTable = "CREATE TABLE BLC_CUSTOMER_ROLE (" +
            "CUSTOMER_ROLE_ID BIGINT NOT NULL, " +
            "CUSTOMER_ID BIGINT, " +
            "ROLE_ID BIGINT, " +
            "PRIMARY KEY (CUSTOMER_ROLE_ID))";
        
        stmt.executeUpdate(createCustomerRoleTable);
        System.out.println("BLC_CUSTOMER_ROLE table has been created.");
        
        // Create BLC_ID_GENERATION table
        String createIdGenerationTable = "CREATE TABLE BLC_ID_GENERATION (" +
            "ID_TYPE VARCHAR(255) NOT NULL, " +
            "BATCH_SIZE INT, " +
            "BATCH_START INT, " +
            "ID_MIN INT, " +
            "ID_MAX INT, " +
            "VERSION INT, " +
            "PRIMARY KEY (ID_TYPE))";
        
        stmt.executeUpdate(createIdGenerationTable);
        System.out.println("BLC_ID_GENERATION table has been created.");
        
        // Create BLC_PHONE table
        String createPhoneTable = "CREATE TABLE BLC_PHONE (" +
            "PHONE_ID BIGINT NOT NULL, " +
            "IS_ACTIVE BOOLEAN, " +
            "PHONE_NUMBER VARCHAR(255), " +
            "PRIMARY KEY (PHONE_ID))";
        
        stmt.executeUpdate(createPhoneTable);
        System.out.println("BLC_PHONE table has been created.");
        
        // Create BLC_ROLE table
        String createRoleTable = "CREATE TABLE BLC_ROLE (" +
            "ROLE_ID BIGINT NOT NULL, " +
            "ROLE_NAME VARCHAR(255), " +
            "PRIMARY KEY (ROLE_ID))";
        
        stmt.executeUpdate(createRoleTable);
        System.out.println("BLC_ROLE table has been created.");
        
        // Create BLC_STATE table
        String createStateTable = "CREATE TABLE BLC_STATE (" +
            "ABBREVIATION VARCHAR(255) NOT NULL, " +
            "NAME VARCHAR(255) NOT NULL, " +
            "COUNTRY VARCHAR(255), " +
            "PRIMARY KEY (ABBREVIATION))";
        
        stmt.executeUpdate(createStateTable);
        System.out.println("BLC_STATE table has been created.");
        
        // Create BLC_ADMIN_USER_ADDTL_FIELDS table
        String createAdminUserAddtlFieldsTable = "CREATE TABLE BLC_ADMIN_USER_ADDTL_FIELDS (" +
            "ADMIN_USER_ID BIGINT NOT NULL, " +
            "FIELD_NAME VARCHAR(255) NOT NULL, " +
            "FIELD_VALUE VARCHAR(255), " +
            "PRIMARY KEY (ADMIN_USER_ID, FIELD_NAME))";
        stmt.executeUpdate(createAdminUserAddtlFieldsTable);
        System.out.println("BLC_ADMIN_USER_ADDTL_FIELDS table has been created.");
        
        // Create BLC_CUSTOMER_PAYMENT_FIELDS table
        String createCustomerPaymentFieldsTable = "CREATE TABLE BLC_CUSTOMER_PAYMENT_FIELDS (" +
            "CUSTOMER_PAYMENT_ID BIGINT NOT NULL, " +
            "FIELD_NAME VARCHAR(255) NOT NULL, " +
            "FIELD_VALUE VARCHAR(255), " +
            "PRIMARY KEY (CUSTOMER_PAYMENT_ID, FIELD_NAME))";
        stmt.executeUpdate(createCustomerPaymentFieldsTable);
        System.out.println("BLC_CUSTOMER_PAYMENT_FIELDS table has been created.");
        
        // Create BLC_OFFER_INFO_FIELDS table
        String createOfferInfoFieldsTable = "CREATE TABLE BLC_OFFER_INFO_FIELDS (" +
            "OFFER_INFO_FIELDS_ID BIGINT NOT NULL, " +
            "FIELD_NAME VARCHAR(255) NOT NULL, " +
            "FIELD_VALUE VARCHAR(255), " +
            "PRIMARY KEY (OFFER_INFO_FIELDS_ID, FIELD_NAME))";
        stmt.executeUpdate(createOfferInfoFieldsTable);
        System.out.println("BLC_OFFER_INFO_FIELDS table has been created.");
        
        // Create BLC_TRANS_ADDITNL_FIELDS table
        String createTransAdditnlFieldsTable = "CREATE TABLE BLC_TRANS_ADDITNL_FIELDS (" +
            "PAYMENT_TRANSACTION_ID BIGINT NOT NULL, " +
            "FIELD_NAME VARCHAR(255) NOT NULL, " +
            "FIELD_VALUE VARCHAR(255), " +
            "PRIMARY KEY (PAYMENT_TRANSACTION_ID, FIELD_NAME))";
        stmt.executeUpdate(createTransAdditnlFieldsTable);
        System.out.println("BLC_TRANS_ADDITNL_FIELDS table has been created.");
        
        // Create BLC_FIELD_SEARCH_TYPES table
        String createFieldSearchTypesTable = "CREATE TABLE BLC_FIELD_SEARCH_TYPES (" +
            "FIELD_ID BIGINT NOT NULL, " +
            "SEARCHABLE_FIELD_TYPE VARCHAR(255) NOT NULL, " +
            "PRIMARY KEY (FIELD_ID, SEARCHABLE_FIELD_TYPE))";
        stmt.executeUpdate(createFieldSearchTypesTable);
        System.out.println("BLC_FIELD_SEARCH_TYPES table has been created.");
        
        // Create BLC_ORDER_ITEM_ADD_ATTR table
        String createOrderItemAddAttrTable = "CREATE TABLE BLC_ORDER_ITEM_ADD_ATTR (" +
            "ORDER_ITEM_ID BIGINT NOT NULL, " +
            "NAME VARCHAR(255) NOT NULL, " +
            "VALUE VARCHAR(255), " +
            "PRIMARY KEY (ORDER_ITEM_ID, NAME))";
        stmt.executeUpdate(createOrderItemAddAttrTable);
        System.out.println("BLC_ORDER_ITEM_ADD_ATTR table has been created.");
        
        // Create BLC_SKU_FULFILLMENT_FLAT_RATES table
        String createSkuFulfillmentFlatRatesTable = "CREATE TABLE BLC_SKU_FULFILLMENT_FLAT_RATES (" +
            "SKU_ID BIGINT NOT NULL, " +
            "FULFILLMENT_OPTION_ID BIGINT NOT NULL, " +
            "RATE DECIMAL(19,5), " +
            "PRIMARY KEY (SKU_ID, FULFILLMENT_OPTION_ID))";
        stmt.executeUpdate(createSkuFulfillmentFlatRatesTable);
        System.out.println("BLC_SKU_FULFILLMENT_FLAT_RATES table has been created.");
        
        // Create BLC_CATEGORY_IMAGE table
        String createCategoryImageTable = "CREATE TABLE BLC_CATEGORY_IMAGE (" +
            "CATEGORY_ID BIGINT NOT NULL, " +
            "NAME VARCHAR(255) NOT NULL, " +
            "URL VARCHAR(255), " +
            "PRIMARY KEY (CATEGORY_ID, NAME))";
        stmt.executeUpdate(createCategoryImageTable);
        System.out.println("BLC_CATEGORY_IMAGE table has been created.");
        
        // Create indexes
        String createSysPropNameIndex = "CREATE INDEX BLC_SYS_PROP_NAME_INDEX ON BLC_SYSTEM_PROPERTY (PROPERTY_NAME)";
        stmt.executeUpdate(createSysPropNameIndex);
        System.out.println("BLC_SYS_PROP_NAME_INDEX index has been created.");
    }
    
    private static void createAllSequences(Statement stmt) throws SQLException {
        // Create sequences
        String createAddressSeq = "CREATE SEQUENCE BLC_ADDRESS_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createAddressSeq);
        System.out.println("BLC_ADDRESS_SEQ sequence has been created.");
        
        String createAdditionalOfferInfoSeq = "CREATE SEQUENCE BLC_ADDITIONAL_OFFER_INFO_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createAdditionalOfferInfoSeq);
        System.out.println("BLC_ADDITIONAL_OFFER_INFO_SEQ sequence has been created.");
        
        String createAdminModuleSeq = "CREATE SEQUENCE BLC_ADMIN_MODULE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createAdminModuleSeq);
        System.out.println("BLC_ADMIN_MODULE_SEQ sequence has been created.");
        
        String createAdminSectionSeq = "CREATE SEQUENCE BLC_ADMIN_SECTION_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createAdminSectionSeq);
        System.out.println("BLC_ADMIN_SECTION_SEQ sequence has been created.");
        
        String createAdminPermissionSeq = "CREATE SEQUENCE BLC_ADMIN_PERMISSION_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createAdminPermissionSeq);
        System.out.println("BLC_ADMIN_PERMISSION_SEQ sequence has been created.");
        
        String createSystemPropertySeq = "CREATE SEQUENCE BLC_SYSTEM_PROPERTY_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSystemPropertySeq);
        System.out.println("BLC_SYSTEM_PROPERTY_SEQ sequence has been created.");
        
        String createAdminPasswordTokenSeq = "CREATE SEQUENCE BLC_ADMIN_PASSWORD_TOKEN_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createAdminPasswordTokenSeq);
        System.out.println("BLC_ADMIN_PASSWORD_TOKEN_SEQ sequence has been created.");
        
        String createAdminRoleSeq = "CREATE SEQUENCE BLC_ADMIN_ROLE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createAdminRoleSeq);
        System.out.println("BLC_ADMIN_ROLE_SEQ sequence has been created.");
        
        String createAdminPermissionEntitySeq = "CREATE SEQUENCE BLC_ADMIN_PERMISSION_ENTITY_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createAdminPermissionEntitySeq);
        System.out.println("BLC_ADMIN_PERMISSION_ENTITY_SEQ sequence has been created.");
        
        String createAdminUserSeq = "CREATE SEQUENCE BLC_ADMIN_USER_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createAdminUserSeq);
        System.out.println("BLC_ADMIN_USER_SEQ sequence has been created.");
        
        String createStaticAssetDescSeq = "CREATE SEQUENCE BLC_STATIC_ASSET_DESC_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createStaticAssetDescSeq);
        System.out.println("BLC_STATIC_ASSET_DESC_SEQ sequence has been created.");
        
        String createStaticAssetSeq = "CREATE SEQUENCE BLC_STATIC_ASSET_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createStaticAssetSeq);
        System.out.println("BLC_STATIC_ASSET_SEQ sequence has been created.");
        
        String createStaticAssetStrgSeq = "CREATE SEQUENCE BLC_STATIC_ASSET_STRG_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createStaticAssetStrgSeq);
        System.out.println("BLC_STATIC_ASSET_STRG_SEQ sequence has been created.");
        
        String createImgStaticAssetSeq = "CREATE SEQUENCE BLC_IMG_STATIC_ASSET_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createImgStaticAssetSeq);
        System.out.println("BLC_IMG_STATIC_ASSET_SEQ sequence has been created.");
        
        String createUrlHandlerSeq = "CREATE SEQUENCE BLC_URL_HANDLER_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createUrlHandlerSeq);
        System.out.println("BLC_URL_HANDLER_SEQ sequence has been created.");
        
        String createFldEnumSeq = "CREATE SEQUENCE BLC_FLD_ENUM_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFldEnumSeq);
        System.out.println("BLC_FLD_ENUM_SEQ sequence has been created.");
        
        String createFldEnumItemSeq = "CREATE SEQUENCE BLC_FLD_ENUM_ITEM_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFldEnumItemSeq);
        System.out.println("BLC_FLD_ENUM_ITEM_SEQ sequence has been created.");
        
        String createFldGroupSeq = "CREATE SEQUENCE BLC_FLD_GROUP_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFldGroupSeq);
        System.out.println("BLC_FLD_GROUP_SEQ sequence has been created.");
        
        String createPageTmplSeq = "CREATE SEQUENCE BLC_PAGE_TMPLT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createPageTmplSeq);
        System.out.println("BLC_PAGE_TMPLT_SEQ sequence has been created.");
        
        String createPageRuleSeq = "CREATE SEQUENCE BLC_PAGE_RULE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createPageRuleSeq);
        System.out.println("BLC_PAGE_RULE_SEQ sequence has been created.");
        
        String createPageItemCriteriaSeq = "CREATE SEQUENCE BLC_PAGE_ITEM_CRITERIA_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createPageItemCriteriaSeq);
        System.out.println("BLC_PAGE_ITEM_CRITERIA_SEQ sequence has been created.");
        
        String createPageSeq = "CREATE SEQUENCE BLC_PAGE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createPageSeq);
        System.out.println("BLC_PAGE_SEQ sequence has been created.");
        
        String createFldDefSeq = "CREATE SEQUENCE BLC_FLD_DEF_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFldDefSeq);
        System.out.println("BLC_FLD_DEF_SEQ sequence has been created.");
        
        String createPageFldSeq = "CREATE SEQUENCE BLC_PAGE_FLD_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createPageFldSeq);
        System.out.println("BLC_PAGE_FLD_SEQ sequence has been created.");
        
        String createScFldSeq = "CREATE SEQUENCE BLC_SC_FLD_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createScFldSeq);
        System.out.println("BLC_SC_FLD_SEQ sequence has been created.");
        
        String createScFldTmplSeq = "CREATE SEQUENCE BLC_SC_FLD_TMPLT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createScFldTmplSeq);
        System.out.println("BLC_SC_FLD_TMPLT_SEQ sequence has been created.");
        
        String createScSeq = "CREATE SEQUENCE BLC_SC_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createScSeq);
        System.out.println("BLC_SC_SEQ sequence has been created.");
        
        String createScItemCriteriaSeq = "CREATE SEQUENCE BLC_SC_ITEM_CRITERIA_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createScItemCriteriaSeq);
        System.out.println("BLC_SC_ITEM_CRITERIA_SEQ sequence has been created.");
        
        String createScRuleSeq = "CREATE SEQUENCE BLC_SC_RULE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createScRuleSeq);
        System.out.println("BLC_SC_RULE_SEQ sequence has been created.");
        
        String createScTypeSeq = "CREATE SEQUENCE BLC_SC_TYPE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createScTypeSeq);
        System.out.println("BLC_SC_TYPE_SEQ sequence has been created.");
        
        String createQualCritScXrefSeq = "CREATE SEQUENCE BLC_QUAL_CRIT_SC_XREF_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createQualCritScXrefSeq);
        System.out.println("BLC_QUAL_CRIT_SC_XREF_SEQ sequence has been created.");
        
        String createCustSiteMapGenCfgSeq = "CREATE SEQUENCE BLC_CUST_SITE_MAP_GEN_CFG_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCustSiteMapGenCfgSeq);
        System.out.println("BLC_CUST_SITE_MAP_GEN_CFG_SEQ sequence has been created.");
        
        String createSiteMapCfgSeq = "CREATE SEQUENCE BLC_SITE_MAP_CFG_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSiteMapCfgSeq);
        System.out.println("BLC_SITE_MAP_CFG_SEQ sequence has been created.");
        
        String createSiteSeq = "CREATE SEQUENCE BLC_SITE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSiteSeq);
        System.out.println("BLC_SITE_SEQ sequence has been created.");
        
        String createSiteMapGenCfgSeq = "CREATE SEQUENCE BLC_SITE_MAP_GEN_CFG_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSiteMapGenCfgSeq);
        System.out.println("BLC_SITE_MAP_GEN_CFG_SEQ sequence has been created.");
        
        String createSiteMapUrlEntrySeq = "CREATE SEQUENCE BLC_SITE_MAP_URL_ENTRY_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSiteMapUrlEntrySeq);
        System.out.println("BLC_SITE_MAP_URL_ENTRY_SEQ sequence has been created.");
        
        String createLocaleSeq = "CREATE SEQUENCE BLC_LOCALE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createLocaleSeq);
        System.out.println("BLC_LOCALE_SEQ sequence has been created.");
        
        String createEmailTrackingClicksSeq = "CREATE SEQUENCE BLC_EMAIL_TRACKING_CLICKS_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createEmailTrackingClicksSeq);
        System.out.println("BLC_EMAIL_TRACKING_CLICKS_SEQ sequence has been created.");
        
        String createEmailTrackingSeq = "CREATE SEQUENCE BLC_EMAIL_TRACKING_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createEmailTrackingSeq);
        System.out.println("BLC_EMAIL_TRACKING_SEQ sequence has been created.");
        
        String createEmailTrackingOpensSeq = "CREATE SEQUENCE BLC_EMAIL_TRACKING_OPENS_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createEmailTrackingOpensSeq);
        System.out.println("BLC_EMAIL_TRACKING_OPENS_SEQ sequence has been created.");
        
        String createCurrencySeq = "CREATE SEQUENCE BLC_CURRENCY_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCurrencySeq);
        System.out.println("BLC_CURRENCY_SEQ sequence has been created.");
        
        String createModuleConfigurationSeq = "CREATE SEQUENCE BLC_MODULE_CONFIGURATION_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createModuleConfigurationSeq);
        System.out.println("BLC_MODULE_CONFIGURATION_SEQ sequence has been created.");
        
        String createRatingSummarySeq = "CREATE SEQUENCE BLC_RATING_SUMMARY_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createRatingSummarySeq);
        System.out.println("BLC_RATING_SUMMARY_SEQ sequence has been created.");
        
        String createStoreSeq = "CREATE SEQUENCE BLC_STORE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createStoreSeq);
        System.out.println("BLC_STORE_SEQ sequence has been created.");
        
        String createReviewDetailSeq = "CREATE SEQUENCE BLC_REVIEW_DETAIL_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createReviewDetailSeq);
        System.out.println("BLC_REVIEW_DETAIL_SEQ sequence has been created.");
        
        String createZipCodeSeq = "CREATE SEQUENCE BLC_ZIP_CODE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createZipCodeSeq);
        System.out.println("BLC_ZIP_CODE_SEQ sequence has been created.");
        
        String createOrderPaymentTransactionSeq = "CREATE SEQUENCE BLC_ORDER_PAYMENT_TRANSACTION_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOrderPaymentTransactionSeq);
        System.out.println("BLC_ORDER_PAYMENT_TRANSACTION_SEQ sequence has been created.");
        
        String createReviewFeedbackSeq = "CREATE SEQUENCE BLC_REVIEW_FEEDBACK_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createReviewFeedbackSeq);
        System.out.println("BLC_REVIEW_FEEDBACK_SEQ sequence has been created.");
        
        String createPaymentLogSeq = "CREATE SEQUENCE BLC_PAYMENT_LOG_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createPaymentLogSeq);
        System.out.println("BLC_PAYMENT_LOG_SEQ sequence has been created.");
        
        String createRatingDetailSeq = "CREATE SEQUENCE BLC_RATING_DETAIL_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createRatingDetailSeq);
        System.out.println("BLC_RATING_DETAIL_SEQ sequence has been created.");
        
        String createOrderPaymentSeq = "CREATE SEQUENCE BLC_ORDER_PAYMENT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOrderPaymentSeq);
        System.out.println("BLC_ORDER_PAYMENT_SEQ sequence has been created.");
        
        String createBankAccountPaymentSeq = "CREATE SEQUENCE BLC_BANK_ACCOUNT_PAYMENT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createBankAccountPaymentSeq);
        System.out.println("BLC_BANK_ACCOUNT_PAYMENT_SEQ sequence has been created.");
        
        String createCreditCardPaymentSeq = "CREATE SEQUENCE BLC_CREDIT_CARD_PAYMENT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCreditCardPaymentSeq);
        System.out.println("BLC_CREDIT_CARD_PAYMENT_SEQ sequence has been created.");
        
        String createGiftCardPaymentSeq = "CREATE SEQUENCE BLC_GIFT_CARD_PAYMENT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createGiftCardPaymentSeq);
        System.out.println("BLC_GIFT_CARD_PAYMENT_SEQ sequence has been created.");
        
        String createCatSearchFacetXrefSeq = "CREATE SEQUENCE BLC_CAT_SEARCH_FACET_XREF_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCatSearchFacetXrefSeq);
        System.out.println("BLC_CAT_SEARCH_FACET_XREF_SEQ sequence has been created.");
        
        String createSearchFacetXrefSeq = "CREATE SEQUENCE BLC_SEARCH_FACET_XREF_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSearchFacetXrefSeq);
        System.out.println("BLC_SEARCH_FACET_XREF_SEQ sequence has been created.");
        
        String createFieldSeq = "CREATE SEQUENCE BLC_FIELD_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFieldSeq);
        System.out.println("BLC_FIELD_SEQ sequence has been created.");
        
        String createCatSearchFacetExclXrefSeq = "CREATE SEQUENCE BLC_CAT_SEARCH_FACET_EXCL_XREF_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCatSearchFacetExclXrefSeq);
        System.out.println("BLC_CAT_SEARCH_FACET_EXCL_XREF_SEQ sequence has been created.");
        
        String createSearchFacetSeq = "CREATE SEQUENCE BLC_SEARCH_FACET_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSearchFacetSeq);
        System.out.println("BLC_SEARCH_FACET_SEQ sequence has been created.");
        
        String createSearchFacetRangeSeq = "CREATE SEQUENCE BLC_SEARCH_FACET_RANGE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSearchFacetRangeSeq);
        System.out.println("BLC_SEARCH_FACET_RANGE_SEQ sequence has been created.");
        
        String createSearchInterceptSeq = "CREATE SEQUENCE BLC_SEARCH_INTERCEPT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSearchInterceptSeq);
        System.out.println("BLC_SEARCH_INTERCEPT_SEQ sequence has been created.");
        
        String createShippingRateSeq = "CREATE SEQUENCE BLC_SHIPPING_RATE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createShippingRateSeq);
        System.out.println("BLC_SHIPPING_RATE_SEQ sequence has been created.");
        
        String createSearchSynonymSeq = "CREATE SEQUENCE BLC_SEARCH_SYNONYM_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSearchSynonymSeq);
        System.out.println("BLC_SEARCH_SYNONYM_SEQ sequence has been created.");
        
        String createFulfillmentOptBandedPrcSeq = "CREATE SEQUENCE BLC_FULFILLMENT_OPT_BANDED_PRC_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFulfillmentOptBandedPrcSeq);
        System.out.println("BLC_FULFILLMENT_OPT_BANDED_PRC_SEQ sequence has been created.");
        
        String createFulfillmentOptBandedWgtSeq = "CREATE SEQUENCE BLC_FULFILLMENT_OPT_BANDED_WGT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFulfillmentOptBandedWgtSeq);
        System.out.println("BLC_FULFILLMENT_OPT_BANDED_WGT_SEQ sequence has been created.");
        
        String createFulfillmentOptionFixedSeq = "CREATE SEQUENCE BLC_FULFILLMENT_OPTION_FIXED_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFulfillmentOptionFixedSeq);
        System.out.println("BLC_FULFILLMENT_OPTION_FIXED_SEQ sequence has been created.");
        
        String createCodeTypesSeq = "CREATE SEQUENCE BLC_CODE_TYPES_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCodeTypesSeq);
        System.out.println("BLC_CODE_TYPES_SEQ sequence has been created.");
        
        String createFulfillmentPriceBandSeq = "CREATE SEQUENCE BLC_FULFILLMENT_PRICE_BAND_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFulfillmentPriceBandSeq);
        System.out.println("BLC_FULFILLMENT_PRICE_BAND_SEQ sequence has been created.");
        
        String createFulfillmentWeightBandSeq = "CREATE SEQUENCE BLC_FULFILLMENT_WEIGHT_BAND_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFulfillmentWeightBandSeq);
        System.out.println("BLC_FULFILLMENT_WEIGHT_BAND_SEQ sequence has been created.");
        
        String createBundItemFeePriceSeq = "CREATE SEQUENCE BLC_BUND_ITEM_FEE_PRICE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createBundItemFeePriceSeq);
        System.out.println("BLC_BUND_ITEM_FEE_PRICE_SEQ sequence has been created.");
        
        String createBundleOrderItemSeq = "CREATE SEQUENCE BLC_BUNDLE_ORDER_ITEM_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createBundleOrderItemSeq);
        System.out.println("BLC_BUNDLE_ORDER_ITEM_SEQ sequence has been created.");
        
        String createUserConnectionSeq = "CREATE SEQUENCE BLC_UserConnection_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createUserConnectionSeq);
        System.out.println("BLC_UserConnection_SEQ sequence has been created.");
        
        String createDiscreteOrderItemSeq = "CREATE SEQUENCE BLC_DISCRETE_ORDER_ITEM_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createDiscreteOrderItemSeq);
        System.out.println("BLC_DISCRETE_ORDER_ITEM_SEQ sequence has been created.");
        
        String createDiscItemFeePriceSeq = "CREATE SEQUENCE BLC_DISC_ITEM_FEE_PRICE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createDiscItemFeePriceSeq);
        System.out.println("BLC_DISC_ITEM_FEE_PRICE_SEQ sequence has been created.");
        
        String createDynDiscreteOrderItemSeq = "CREATE SEQUENCE BLC_DYN_DISCRETE_ORDER_ITEM_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createDynDiscreteOrderItemSeq);
        System.out.println("BLC_DYN_DISCRETE_ORDER_ITEM_SEQ sequence has been created.");
        
        String createFulfillmentGroupFeeSeq = "CREATE SEQUENCE BLC_FULFILLMENT_GROUP_FEE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFulfillmentGroupFeeSeq);
        System.out.println("BLC_FULFILLMENT_GROUP_FEE_SEQ sequence has been created.");
        
        String createFulfillmentGroupSeq = "CREATE SEQUENCE BLC_FULFILLMENT_GROUP_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFulfillmentGroupSeq);
        System.out.println("BLC_FULFILLMENT_GROUP_SEQ sequence has been created.");
        
        String createFulfillmentGroupItemSeq = "CREATE SEQUENCE BLC_FULFILLMENT_GROUP_ITEM_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFulfillmentGroupItemSeq);
        System.out.println("BLC_FULFILLMENT_GROUP_ITEM_SEQ sequence has been created.");
        
        String createFulfillmentOptionSeq = "CREATE SEQUENCE BLC_FULFILLMENT_OPTION_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFulfillmentOptionSeq);
        System.out.println("BLC_FULFILLMENT_OPTION_SEQ sequence has been created.");
        
        String createGiftwrapOrderItemSeq = "CREATE SEQUENCE BLC_GIFTWRAP_ORDER_ITEM_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createGiftwrapOrderItemSeq);
        System.out.println("BLC_GIFTWRAP_ORDER_ITEM_SEQ sequence has been created.");
        
        String createOrderItemSeq = "CREATE SEQUENCE BLC_ORDER_ITEM_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOrderItemSeq);
        System.out.println("BLC_ORDER_ITEM_SEQ sequence has been created.");
        
        String createCandidateItemOfferSeq = "CREATE SEQUENCE BLC_CANDIDATE_ITEM_OFFER_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCandidateItemOfferSeq);
        System.out.println("BLC_CANDIDATE_ITEM_OFFER_SEQ sequence has been created.");
        
        String createItemOfferQualifierSeq = "CREATE SEQUENCE BLC_ITEM_OFFER_QUALIFIER_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createItemOfferQualifierSeq);
        System.out.println("BLC_ITEM_OFFER_QUALIFIER_SEQ sequence has been created.");
        
        String createCandidateOrderOfferSeq = "CREATE SEQUENCE BLC_CANDIDATE_ORDER_OFFER_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCandidateOrderOfferSeq);
        System.out.println("BLC_CANDIDATE_ORDER_OFFER_SEQ sequence has been created.");
        
        String createOrderMultishipOptionSeq = "CREATE SEQUENCE BLC_ORDER_MULTISHIP_OPTION_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOrderMultishipOptionSeq);
        System.out.println("BLC_ORDER_MULTISHIP_OPTION_SEQ sequence has been created.");
        
        String createQualCritOfferXrefSeq = "CREATE SEQUENCE BLC_QUAL_CRIT_OFFER_XREF_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createQualCritOfferXrefSeq);
        System.out.println("BLC_QUAL_CRIT_OFFER_XREF_SEQ sequence has been created.");
        
        String createCustomerOfferXrefSeq = "CREATE SEQUENCE BLC_CUSTOMER_OFFER_XREF_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCustomerOfferXrefSeq);
        System.out.println("BLC_CUSTOMER_OFFER_XREF_SEQ sequence has been created.");
        
        String createOrderItemPriceDtlSeq = "CREATE SEQUENCE BLC_ORDER_ITEM_PRICE_DTL_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOrderItemPriceDtlSeq);
        System.out.println("BLC_ORDER_ITEM_PRICE_DTL_SEQ sequence has been created.");
        
        String createPersonalMessageSeq = "CREATE SEQUENCE BLC_PERSONAL_MESSAGE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createPersonalMessageSeq);
        System.out.println("BLC_PERSONAL_MESSAGE_SEQ sequence has been created.");
        
        String createFgAdjustmentSeq = "CREATE SEQUENCE BLC_FG_ADJUSTMENT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createFgAdjustmentSeq);
        System.out.println("BLC_FG_ADJUSTMENT_SEQ sequence has been created.");
        
        String createCandidateFgOfferSeq = "CREATE SEQUENCE BLC_CANDIDATE_FG_OFFER_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCandidateFgOfferSeq);
        System.out.println("BLC_CANDIDATE_FG_OFFER_SEQ sequence has been created.");
        
        String createCategoryMediaMapSeq = "CREATE SEQUENCE BLC_CATEGORY_MEDIA_MAP_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCategoryMediaMapSeq);
        System.out.println("BLC_CATEGORY_MEDIA_MAP_SEQ sequence has been created.");
        
        String createOfferAuditSeq = "CREATE SEQUENCE BLC_OFFER_AUDIT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOfferAuditSeq);
        System.out.println("BLC_OFFER_AUDIT_SEQ sequence has been created.");
        
        String createOrderSeq = "CREATE SEQUENCE BLC_ORDER_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOrderSeq);
        System.out.println("BLC_ORDER_SEQ sequence has been created.");
        
        String createOfferCodeSeq = "CREATE SEQUENCE BLC_OFFER_CODE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOfferCodeSeq);
        System.out.println("BLC_OFFER_CODE_SEQ sequence has been created.");
        
        String createOfferSeq = "CREATE SEQUENCE BLC_OFFER_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOfferSeq);
        System.out.println("BLC_OFFER_SEQ sequence has been created.");
        
        String createOfferInfoSeq = "CREATE SEQUENCE BLC_OFFER_INFO_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOfferInfoSeq);
        System.out.println("BLC_OFFER_INFO_SEQ sequence has been created.");
        
        String createCategoryProductXrefSeq = "CREATE SEQUENCE BLC_CATEGORY_PRODUCT_XREF_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCategoryProductXrefSeq);
        System.out.println("BLC_CATEGORY_PRODUCT_XREF_SEQ sequence has been created.");
        
        String createOrderAdjustmentSeq = "CREATE SEQUENCE BLC_ORDER_ADJUSTMENT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOrderAdjustmentSeq);
        System.out.println("BLC_ORDER_ADJUSTMENT_SEQ sequence has been created.");
        
        String createCatSiteMapGenCfgSeq = "CREATE SEQUENCE BLC_CAT_SITE_MAP_GEN_CFG_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCatSiteMapGenCfgSeq);
        System.out.println("BLC_CAT_SITE_MAP_GEN_CFG_SEQ sequence has been created.");
        
        String createOrderItemAdjustmentSeq = "CREATE SEQUENCE BLC_ORDER_ITEM_ADJUSTMENT_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOrderItemAdjustmentSeq);
        System.out.println("BLC_ORDER_ITEM_ADJUSTMENT_SEQ sequence has been created.");
        
        String createCategoryXrefSeq = "CREATE SEQUENCE BLC_CATEGORY_XREF_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCategoryXrefSeq);
        System.out.println("BLC_CATEGORY_XREF_SEQ sequence has been created.");
        
        String createOfferRuleSeq = "CREATE SEQUENCE BLC_OFFER_RULE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOfferRuleSeq);
        System.out.println("BLC_OFFER_RULE_SEQ sequence has been created.");
        
        String createOrderItemDtlAdjSeq = "CREATE SEQUENCE BLC_ORDER_ITEM_DTL_ADJ_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOrderItemDtlAdjSeq);
        System.out.println("BLC_ORDER_ITEM_DTL_ADJ_SEQ sequence has been created.");
        
        String createSkuAvailabilitySeq = "CREATE SEQUENCE BLC_SKU_AVAILABILITY_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSkuAvailabilitySeq);
        System.out.println("BLC_SKU_AVAILABILITY_SEQ sequence has been created.");
        
        String createOfferItemCriteriaSeq = "CREATE SEQUENCE BLC_OFFER_ITEM_CRITERIA_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createOfferItemCriteriaSeq);
        System.out.println("BLC_OFFER_ITEM_CRITERIA_SEQ sequence has been created.");
        
        String createProductFeaturedSeq = "CREATE SEQUENCE BLC_PRODUCT_FEATURED_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createProductFeaturedSeq);
        System.out.println("BLC_PRODUCT_FEATURED_SEQ sequence has been created.");
        
        String createProductBundleSeq = "CREATE SEQUENCE BLC_PRODUCT_BUNDLE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createProductBundleSeq);
        System.out.println("BLC_PRODUCT_BUNDLE_SEQ sequence has been created.");
        
        String createProductOptionValueSeq = "CREATE SEQUENCE BLC_PRODUCT_OPTION_VALUE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createProductOptionValueSeq);
        System.out.println("BLC_PRODUCT_OPTION_VALUE_SEQ sequence has been created.");
        
        String createProductOptionSeq = "CREATE SEQUENCE BLC_PRODUCT_OPTION_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createProductOptionSeq);
        System.out.println("BLC_PRODUCT_OPTION_SEQ sequence has been created.");
        
        String createProductOptionXrefSeq = "CREATE SEQUENCE BLC_PRODUCT_OPTION_XREF_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createProductOptionXrefSeq);
        System.out.println("BLC_PRODUCT_OPTION_XREF_SEQ sequence has been created.");
        
        String createChallengeQuestionSeq = "CREATE SEQUENCE BLC_CHALLENGE_QUESTION_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createChallengeQuestionSeq);
        System.out.println("BLC_CHALLENGE_QUESTION_SEQ sequence has been created.");
        
        String createSkuBundleItemSeq = "CREATE SEQUENCE BLC_SKU_BUNDLE_ITEM_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSkuBundleItemSeq);
        System.out.println("BLC_SKU_BUNDLE_ITEM_SEQ sequence has been created.");
        
        String createCountrySeq = "CREATE SEQUENCE BLC_COUNTRY_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCountrySeq);
        System.out.println("BLC_COUNTRY_SEQ sequence has been created.");
        
        String createCustomerPasswordTokenSeq = "CREATE SEQUENCE BLC_CUSTOMER_PASSWORD_TOKEN_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCustomerPasswordTokenSeq);
        System.out.println("BLC_CUSTOMER_PASSWORD_TOKEN_SEQ sequence has been created.");
        
        String createCustomerSeq = "CREATE SEQUENCE BLC_CUSTOMER_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCustomerSeq);
        System.out.println("BLC_CUSTOMER_SEQ sequence has been created.");
        
        String createSkuSeq = "CREATE SEQUENCE BLC_SKU_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createSkuSeq);
        System.out.println("BLC_SKU_SEQ sequence has been created.");
        
        String createCustomerRoleSeq = "CREATE SEQUENCE BLC_CUSTOMER_ROLE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createCustomerRoleSeq);
        System.out.println("BLC_CUSTOMER_ROLE_SEQ sequence has been created.");
        
        String createIdGenerationSeq = "CREATE SEQUENCE BLC_ID_GENERATION_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createIdGenerationSeq);
        System.out.println("BLC_ID_GENERATION_SEQ sequence has been created.");
        
        String createPhoneSeq = "CREATE SEQUENCE BLC_PHONE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createPhoneSeq);
        System.out.println("BLC_PHONE_SEQ sequence has been created.");
        
        String createRoleSeq = "CREATE SEQUENCE BLC_ROLE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createRoleSeq);
        System.out.println("BLC_ROLE_SEQ sequence has been created.");
        
        String createStateSeq = "CREATE SEQUENCE BLC_STATE_SEQ START WITH 1 INCREMENT BY 50";
        stmt.executeUpdate(createStateSeq);
        System.out.println("BLC_STATE_SEQ sequence has been created.");
    }
    
    private static void insertSampleData(Statement stmt) throws SQLException {
        // Insert sample data from load_admin_menu.sql
        String[] insertStatements = {
            "INSERT INTO BLC_ADMIN_MODULE (ADMIN_MODULE_ID, NAME, MODULE_KEY, ICON, DISPLAY_ORDER) VALUES (-1,'Catalog','BLCMerchandising', 'icon-barcode', 100)",
            "INSERT INTO BLC_ADMIN_MODULE (ADMIN_MODULE_ID, NAME, MODULE_KEY, ICON, DISPLAY_ORDER) VALUES (-2,'Content','BLCContentManagement', 'icon-file', 200)",
            "INSERT INTO BLC_ADMIN_MODULE (ADMIN_MODULE_ID, NAME, MODULE_KEY, ICON, DISPLAY_ORDER) VALUES (-3,'Customer Care','BLCCustomerCare', 'icon-heart', 300)",
            "INSERT INTO BLC_ADMIN_MODULE (ADMIN_MODULE_ID, NAME, MODULE_KEY, ICON, DISPLAY_ORDER) VALUES (-6,'Design','BLCDesign', 'icon-picture', 400)",
            "INSERT INTO BLC_ADMIN_MODULE (ADMIN_MODULE_ID, NAME, MODULE_KEY, ICON, DISPLAY_ORDER) VALUES (-7,'Site Updates','BLCWorkflow', 'icon-refresh', 500)",
            "INSERT INTO BLC_ADMIN_MODULE (ADMIN_MODULE_ID, NAME, MODULE_KEY, ICON, DISPLAY_ORDER) VALUES (-4,'Security','BLCOpenAdmin', 'icon-user', 600)",
            "INSERT INTO BLC_ADMIN_MODULE (ADMIN_MODULE_ID, NAME, MODULE_KEY, ICON, DISPLAY_ORDER) VALUES (-5,'Settings','BLCModuleConfiguration', 'icon-gear', 700)",
            
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-1, 1000, -1, 'Category', 'Category', '/category', 'org.broadleafcommerce.core.catalog.domain.Category')",
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-2, 2000, -1, 'Product', 'Product', '/product', 'org.broadleafcommerce.core.catalog.domain.Product')",
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-3, 3000, -1, 'Product Options', 'ProductOptions', '/product-options', 'org.broadleafcommerce.core.catalog.domain.ProductOption')",
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-4, 4000, -1, 'Offer', 'Offer', '/offer', 'org.broadleafcommerce.core.offer.domain.Offer')",
            
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-5, 1000, -2, 'Pages', 'Pages', '/pages', 'org.broadleafcommerce.cms.page.domain.Page')",
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-7, 2000, -2, 'Structured Content', 'StructuredContent', '/structured-content', 'org.broadleafcommerce.cms.structure.domain.StructuredContent')",
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-6, 3000, -2, 'Assets', 'Assets', '/assets', 'org.broadleafcommerce.cms.file.domain.StaticAsset')",
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-8, 4000, -2, 'Redirect URL', 'RedirectURL', '/redirect-url', 'org.broadleafcommerce.cms.url.domain.URLHandler')",
            
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-9, 2000, -3, 'Order', 'Order', '/order', 'org.broadleafcommerce.core.order.domain.Order')",
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-10, 1000, -3,'Customer', 'Customer', '/customer', 'org.broadleafcommerce.profile.core.domain.Customer')",
            
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-11, 1000, -4, 'User Management', 'UserManagement', '/user-management', 'org.broadleafcommerce.openadmin.server.security.domain.AdminUser')",
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-12, 2000, -4, 'Role Management', 'RoleManagement', '/role-management', 'org.broadleafcommerce.openadmin.server.security.domain.AdminRole')",
            
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-13, 1000, -5, 'Configuration Management', 'ConfigurationManagement', '/configuration-management', 'org.broadleafcommerce.common.config.domain.ModuleConfiguration')",
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-15, 3000, -5, 'System Property Management', 'SystemPropertyManagement', '/system-properties-management', 'org.broadleafcommerce.common.config.domain.SystemProperty')",
            "INSERT INTO BLC_ADMIN_SECTION (ADMIN_SECTION_ID, DISPLAY_ORDER, ADMIN_MODULE_ID, NAME, SECTION_KEY, URL, CEILING_ENTITY) VALUES (-16, 2000, -5, 'System Properties', 'SystemProperties', '/system-properties', 'org.broadleafcommerce.common.config.domain.SystemProperty')"
        };
        
        for (String insertStatement : insertStatements) {
            stmt.executeUpdate(insertStatement);
        }
        System.out.println("Sample data has been inserted.");
    }
    
    private static void dropTableIfExists(Statement stmt, String tableName) throws SQLException {
        try {
            stmt.executeUpdate("DROP TABLE " + tableName + " IF EXISTS");
            System.out.println("Dropped table: " + tableName);
        } catch (SQLException e) {
            System.out.println("Table " + tableName + " does not exist or could not be dropped.");
        }
    }
    
    private static void dropSequenceIfExists(Statement stmt, String sequenceName) throws SQLException {
        try {
            stmt.executeUpdate("DROP SEQUENCE " + sequenceName);
            System.out.println("Dropped sequence: " + sequenceName);
        } catch (SQLException e) {
            System.out.println("Sequence " + sequenceName + " does not exist or could not be dropped.");
        }
    }
}