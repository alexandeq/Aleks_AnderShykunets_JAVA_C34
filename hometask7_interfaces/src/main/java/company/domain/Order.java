package company.domain;

    public class Order {
        private String dish;
        private String adress;
        private String phoneNumber;
        private String email;

        public Order(String dish, String adress, String phoneNumber, String email) {
            this.dish = dish;
            this.adress = adress;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getDish() {
            return dish;
        }

        public void setDish(String dish) {
            this.dish = dish;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;


        }
    }

