/**

Batching of data stream

Description
Convert a stream of chronological data to batches of data at a given interval.

Consider that a component “StreamReader” is reading a stream of data points from a data source named “DataSource”. Each data point has a timestamp associated with it and they follow a chronological order (if data point dp1 is read before dp2, dp1’s timestamp < dp2’s timestamp). There is no certainty of the rate of generation of these data points.

After reading the data points, it passes it on to another component named “DataProcessor” in batches. A batch consists of all data points in a certain interval of time that was configured into the component “StreamReader”. The data processor discards the data points after processing.

Do not try to implement DataProcessor or DataSource.

*/

public interface IDataSource
{
    void Initialize(Map configurations);
    List<IData> getDataPoints();
    boolean hasMoreData();
}

LinkedInSource, TwitterSource

public interface IStreamReader
{
initialize(IDataSource,IDataProcessor) throws StreamReaderInitializeException;
List<IData> getStream() throws StreamReadException;//this object can be a list of IData
}

class DataStore()
{
//Has Scheduler build in which runs periodically every
}
class streamReader
{
DataSource source;
DataProcessor targetDataProcessor;
DataStore dataStore;
//Have a scheduledExecutorService which sends the data to targetDataProcessor every 10 minutes.
ScheduledExecutorService scheduler= Executor.getScheduledThreads(10);



void initialize(IDataSource inputSource,IDataProcessor inputTargetProcessor) throws StreamReaderInitializeException
{
source=inputSource;
targetDataProcessor=inputTargetProcessor;
d = new DataStore;
scheduler.schedule(new Runnable{
run()
{
//get all the data from dataStore and send it to data processor.
targetDataProcessor.processDataForBatch(dataStore);
}
});
}
private List<IData> getStream() throws StreamReadException
{
while(source.hasMoreData)
{
dataStore.add(source.getDataPoints());
}
}
} 


public interface IData
{
object getData();
timestamp getDataGenerationTime();
}

class DP implements IData
{
Object data;
time dataGenerationTime;
DP(Object inputData, time dataGenerationTime)
{
}
//implement methods
}

public interface IDataProcessor
{
void processDataForBatch(List<IData>);
void sendDataToListeners();
void AddListeners();
}
