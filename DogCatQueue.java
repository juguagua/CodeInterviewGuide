package Basics;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {

    public static class Pet{

        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getPetType(){
            return this.type;
        }

    }
    public static class Dog extends Pet{
        public Dog(){
            super("dog");
        }
    }
    public static class Cat extends Pet{
        public Cat(){
            super("cat");
        }
    }
    public static class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet,long count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet(){
            return this.pet;
        }
        public long getCount(){
            return count;
        }
        public String getEnterPetType(){
            return this.pet.getPetType();
        }
    }

    public static class CatDogQueue{
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long count;

        public CatDogQueue(){
            this.catQ = new LinkedList<PetEnterQueue>();
            this.dogQ = new LinkedList<PetEnterQueue>();
            this.count = 0;
        }
        public void add(Pet pet){
            if (pet.getPetType().equals("dog")){
                this.dogQ.add(new PetEnterQueue(pet,this.count++));
            }else if (pet.getPetType().equals("cat")){
                this.catQ.add(new PetEnterQueue(pet,this.count++));
            }else {
                throw new RuntimeException("err,not dog or cat !");
            }
        }
        public Pet pollAll(){
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                    return dogQ.poll().getPet();
                }else{
                    return catQ.poll().getPet();
                }
            }else if (!this.dogQ.isEmpty()){
                return dogQ.poll().getPet();
            }else if (!this.catQ.isEmpty()){
                return catQ.poll().getPet();
            }else {
                throw new RuntimeException("err,cat and dog is empty!");
            }
        }
        public Dog pollDog(){
            if (!this.dogQ.isEmpty()){
                return (Dog) this.dogQ.poll().getPet();
            }else {
                throw new RuntimeException("err,dogQ is empty!");
            }
        }
        public Cat pollCat(){
            if (!this.catQ.isEmpty()){
                return (Cat) this.catQ.poll().getPet();
            }else {
                throw new RuntimeException("err,catQ is empty!");
            }
        }
        public boolean isEmpty(){
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }



    }

    public static void main(String[] args) {

    }
}
