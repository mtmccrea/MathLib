//////////
	var <>seeds; // todo: seeds. also Pmswitch should use a standard interface to all msets
				// deterministicNext(prev, index)
				// nextSeed, deterministicNextSeed, embedSpyInStream (?)
				// don't work:  read(prev, next)
				// ++
	*fill { arg size, stream;
		^this.new(size).parse(stream, size);
	}
	
	data_ { arg array;
		this.clear(0).addAll(array);
	}
	addAll { arg array;
		data.grow(array.size); 
		array.do({ arg item; this.add(item) });
	}
	
	add { arg item;
		this.put(data.size, item)
	}
	
	put { arg i, item;
		data.put(i, item)
	}
	
	wrapPut { arg i, item;
		this.put(i % data.array.size, item) // check again data.size?
	}
	
		var stream;
		stream = pattern.asStream;
				index + 1 
		}, {
		randOffset = data.size.rand;
			i = (i + randOffset).wrap(0, data.size);
			[i].debug;
		if(notify) { "random lookup due to lack of key".postln };
			while({
				if(outval.isNil or: {index.isNil})
						{ index = this.chooseIndex } 
						{ index = this.nextIndex(index, orderStr.next) };
				//index.postln;
				index = index ?? { "choose index!".postln; this.chooseIndex }; // ??
				outval = data[index];
				outval.notNil
			}, {
				inval = outval.embedInStream(inval)
			});
		this.initDict;
		super.clear(size);
	}
	
		lookUp = FuzzySet.new;
	}

	put { arg index, obj;
		if(obj.notNil, {
			super.put(index, obj); 
			lookUp.put(obj.asSymbol, index)
		});
	}
		if(notify) { "random lookup due to lack of key".postln };
				tryIndex = list.choose;
					}
				) 
				{ 
// use internally later
// pre cleared list
ClearList : List {
	var <size = 0;
	
	add { arg item; array = array.put(size, item); size = size + 1 }
	put { arg i, item;
		array.put(i, item); 
		size = max(size, i+1) 
	}
	insert { arg index, item; array = array.insert(index, item); size = size + 1 }
	removeAt { arg index; var res; 
		res = array.removeAt(index);
		array = array.add(nil);
		if(res.notNil) {size = size - 1 }; 
		^res 
	}
	pop { ^this.removeAt(size - 1) }
	do { arg function;
		this.size.do({ arg i; function.value(array[i],i) });
	}
	reverseDo { arg function;
		this.size.reverseDo({ arg i; function.value(array[i],i) });
	}
	
	grow { arg n=1;
		array = array ++ Array.newClear(n)
	}
}
