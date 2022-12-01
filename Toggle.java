public  class Toggle extends Light {
    protected Toggle(Light l, long p) {
        super(l, p);
    }
    @Override
    public boolean isOn(long p) {

        if(this.p==p || this.p-p==1 || this.p-p==-1){
            return !l.isOn(p);
        }
        return l.isOn(p);
    }

    @Override
    public long mostLeft() {
        long smallest=this.p-1;
        if(l.equals(Light.New())){
            return p-1;
        }
        if( l.mostLeft()<smallest){
            smallest=l.mostLeft();
        }
        return smallest;
    }

    @Override
    public long mostRight() {
        long biggest=this.p+1;
        if(l.equals(Light.New())){
            return p+1 ;
        }
        if(l.mostRight()>biggest){
            biggest=l.mostRight();
        }
        return biggest;
    }

    @Override
    public boolean isRangeOff(long from, long to) {
        //while

        if(from<=to){
            return !isOn(from)&& isRangeOff(from+1,to);

        }
        return true;


    }

    @Override
    public boolean isAllOff() {

        return isRangeOff(mostLeft(),mostRight());

    }

    @Override
    public Light makeAllOff() {
        return Toggle(Toggle(l.makeAllOff(),p),p);

    }


}
